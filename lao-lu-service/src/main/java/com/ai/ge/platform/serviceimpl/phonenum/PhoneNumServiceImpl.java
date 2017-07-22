package com.ai.ge.platform.serviceimpl.phonenum;

import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.exception.ParamException;
import com.ai.ge.platform.mapper.product.NumberInfoMapper;
import com.ai.ge.platform.mapper.sys.SystemAreaMapper;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.model.product.NumberInfoExample;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.PoiExcel2k3Helper;
import com.ai.ge.util.PoiExcel2k7Helper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangying on 17/5/24.
 */
@Service
public class PhoneNumServiceImpl implements PhoneNumService
{
    private Logger logger = LoggerFactory.getLogger(PhoneNumService.class);

    @Resource
    private NumberInfoMapper numberInfoMapper;

    @Resource
    private SystemAreaMapper systemAreaMapper;

    @Resource
    private RedisSpringProxy redisService;

    @Override
    public List<NumberInfo> findListBycount(int count,Long provinceAreaId,Long cityAreaId){
        logger.debug("provinceAreaId===>" + provinceAreaId);
        logger.debug("cityAreaId===>" + cityAreaId);
        List<NumberInfo> rv = numberInfoMapper.findListBycount(count, provinceAreaId, cityAreaId);
        return rv;
    }

    @Override
    public int occpyPhoneNumber(long id){
        int rv = 0;
        NumberInfo record = new NumberInfo();
        //修改时无需修改主键
        //record.setId(id);
        record.setStatus((new Integer(1).shortValue()));
        record.setUpdateTime(new Date());
        NumberInfoExample numberInfoExample = new NumberInfoExample();
        numberInfoExample.createCriteria().andIdEqualTo(id).andStatusEqualTo((new Integer(0).shortValue()));
        rv = numberInfoMapper.updateByExampleSelective(record,numberInfoExample);
        return rv;
    }

    /**
     * 根据条件查询号码 (管理台方法)
     *
     * @param record
     * @return
     */
    @Override
    public List<NumberInfoDto> listNumberInfoDto(NumberInfoDto record)
    {
        return numberInfoMapper.listNumberInfo(record);
    }

    /**
     * 新增号码
     *
     * @param record
     * @return
     */
    @Override
    public int insertNumber(NumberInfo record)
    {
        validateParam(record);

        if (null == record.getCreateTime())
        {
            record.setCreateTime(new Date());
        }

        return numberInfoMapper.insertSelective(record);
    }

    /**
     * 更新号码
     *
     * @param record
     * @param flag 是否参数检查标志
     *             true 检查
     *             fasle 不检查，主要是给页面更新状态使用
     * @return
     */
    @Override
    public int updateNumber(NumberInfo record, boolean flag)
    {
        if (flag)
        {
            validateParam(record);
        }

        if (null == record.getUpdateTime())
        {
            record.setUpdateTime(new Date());
        }

        return numberInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 校验参数
     *
     * @param record
     */
    private void validateParam(NumberInfo record)
    {
        if (null == record.getNumber())
        {
            throw new ParamException("缺少参数号码");
        }

        if (null == record.getStatus())
        {
            throw new ParamException("缺少参数状态");
        }

        if (null == record.getCityAearId())
        {
            throw new ParamException("缺少参数地区");
        }
    }

    /**
     * 随机获取电话号码
     * @param numberCount 需要获得的电话个数
     * @return
     */
    public List<NumberInfo> findListRand(int numberCount,Long provinceAreaId,Long cityAreaId){
        logger.debug("provinceAreaId===>" + provinceAreaId);
        logger.debug("cityAreaId===>" + cityAreaId);
        logger.debug("numberCount===>" + numberCount);

        //add by zhaocy3
        //号码预占使用Redis方案
        //Redis key：AI-WEB-NUMBERINFO-LIST_ + provinceAreaId + "_" + cityAreaId
        String redisKeyNumberInfo = "AI-WEB-NUMBERINFO-LIST_" + provinceAreaId + "_" + cityAreaId;
        Long redisCount = redisService.sCard(redisKeyNumberInfo);
        if(redisCount < numberCount || redisCount == 0){
            List<NumberInfo> list = numberInfoMapper.findListBycount(1000, provinceAreaId, cityAreaId);
            for(NumberInfo numberInfo:list){
                redisService.sAdd(redisKeyNumberInfo,numberInfo);
            }
        }

        return redisService.sRandMember(redisKeyNumberInfo, Long.valueOf(String.valueOf(numberCount)), NumberInfo.class);
        //return numberInfoMapper.findListRand(numberCount,provinceAreaId,cityAreaId);
    }

    @Override
    public int releaseNumber(Long timeout){
        //超时时间
        Date currentDate = new Date();
        Date timeoutDate = new Date();

        Long tm = (null!=timeout)?timeout*1000L:(5 * 60 * 1000L);
        logger.debug("超时时间:"+tm);
        int rv = 0;

        timeoutDate.setTime(currentDate.getTime() - tm);//5分钟

        NumberInfo record= new NumberInfo();
        record.setStatus(Short.parseShort("0"));
        record.setUpdateTime(currentDate);

        NumberInfoExample example = new NumberInfoExample();
        example.createCriteria().andStatusEqualTo(Short.parseShort("1")).andUpdateTimeLessThanOrEqualTo(timeoutDate);
        rv = numberInfoMapper.updateByExampleSelective(record,example);

        return rv;
    }


    /**
     * 导入号码
     *
     * @param inputStream
     * @throws DataException
     */
    @Transactional
    @Override
    public int batchAddNumber(InputStream inputStream) throws DataException
    {
        ArrayList<ArrayList<String>> uploadText = null;
        try {

            try {
                uploadText = new PoiExcel2k3Helper().readExcel(inputStream, 0);
            } catch (Exception e) {
                uploadText = new PoiExcel2k7Helper().readExcel(inputStream, 0);
            }
        } catch (Exception e) {
            logger.error("读取Excel文档异常", e);
            throw new DataException("0", "读取Excel文档异常");
        }

        logger.info("上传文件内容为 " + uploadText);

        List<String> uploadNumber = new ArrayList<String>();
        Set<String> provinceName = new HashSet<String>();
        Set<String> cityName = new HashSet<String>();
        List<NumberInfo> listObjects = new ArrayList<NumberInfo>();


        Pattern p = Pattern.compile("(13[0-9]|15[012356789]|17[3678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = null;

        String number = null;
        Short level = null;
        Long proTypeId = null;
        Short status = null;
        String provinceAear = null;
        String cityAear = null;

        NumberInfo numberInfo = null;

        for (int i = 1; i < uploadText.size(); i++) {

            if (StringUtils.isEmpty(uploadText.get(i).get(0))
                    ||StringUtils.isEmpty(uploadText.get(i).get(1))
                    ||StringUtils.isEmpty(uploadText.get(i).get(2))
                    ||StringUtils.isEmpty(uploadText.get(i).get(3))
                    ||StringUtils.isEmpty(uploadText.get(i).get(4)))
            {
                logger.error("第 " + i + " 行数据为空");
                continue;
            } else {

                number = uploadText.get(i).get(0);

//                DecimalFormat df = new DecimalFormat("0");
//                number = df.format(uploadText.get(i).get(0).toString());


                level = Short.parseShort(uploadText.get(i).get(1));
                proTypeId = Long.parseLong(uploadText.get(i).get(2));
                status = Short.parseShort(uploadText.get(i).get(3));
                provinceAear = uploadText.get(i).get(4);

                // 市区可以不填写
                if (StringUtils.isNotEmpty(uploadText.get(i).get(5)))
                {
                    cityAear = uploadText.get(i).get(5);

                    cityAear = StringUtils.trim(cityAear);
                    cityName.add(cityAear);
                }

                number = StringUtils.trim(number);
                m = p.matcher(number);
                if (!m.matches()) {
                    String message = "第 " + i + " 行数据 " + number + " 不是手机号码";
                    logger.error(message);
                    throw new DataException("0", message);
                }

                numberInfo = new NumberInfo();
                numberInfo.setNumber(number);
                numberInfo.setLevel(level);
                numberInfo.setProTypeId(proTypeId);
                numberInfo.setStatus(status);

                numberInfo.setProvinceName(provinceAear);
                numberInfo.setCityName(cityAear);

                uploadNumber.add(number);
            }

            provinceAear = StringUtils.trim(provinceAear);
            provinceName.add(provinceAear);

            listObjects.add(numberInfo);
        }

        // 校验是否有重复手机号
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        for (String s : uploadNumber) {
            if (!numberMap.containsKey(s)) {
                numberMap.put(s, 0);
            }
            numberMap.put(s, numberMap.get(s) + 1);
        }

        for (Map.Entry<String, Integer> entry : numberMap.entrySet()) {
            if (1 < entry.getValue()) {
                String message = "手机号码 " + entry.getKey() + " 存在 " + entry.getValue() + " 条重复 ";
                logger.error(message);
                throw new DataException("0", message);
            }
        }

        // 省份信息
        List<Map<String, Long>> provinceMapList = systemAreaMapper.listAreaIdName(new ArrayList<String>(provinceName));
        if (provinceName.size() != provinceMapList.size()) {
            String message = "上传数据中地区数据与库中数据匹配不正确";
            logger.error(message);
            throw new DataException("0", message);
        }

        Map<String, Long> provinceMapVal = new HashMap<String, Long>();
        for (Map<String, Long> entry : provinceMapList) {
            provinceMapVal.put(String.valueOf(entry.get("AREA_NAME")), Long.parseLong(String.valueOf(entry.get("AREA_ID"))));
        }

        // 市区信息
        List<Map<String, Long>> cityMapList = systemAreaMapper.listAreaIdName(new ArrayList<String>(cityName));
        if (cityName.size() != cityMapList.size()) {
            String message = "上传数据中地区数据与库中数据匹配不正确";
            logger.error(message);
            throw new DataException("0", message);
        }

        Map<String, Long> cityMapVal = new HashMap<String, Long>();
        for (Map<String, Long> entry : cityMapList) {
            cityMapVal.put(String.valueOf(entry.get("AREA_NAME")), Long.parseLong(String.valueOf(entry.get("AREA_ID"))));
        }

        for (NumberInfo object : listObjects) {
            object.setProvinceAearId(provinceMapVal.get(object.getProvinceName()));
            object.setCityAearId(cityMapVal.get(object.getCityName()));
        }


        List<List<String>> groupUploadNumber = new ArrayList<List<String>>();
        int maxLength = 999;
        int len = (listObjects.size() / maxLength) + 1;

        for (int i = 0; i < len; i++) {
            List<String> objects = new ArrayList<String>();
            for (int j = 0; j < maxLength; j++) {
                int index = i * maxLength + j;
                if (index == listObjects.size()) {
                    break;
                }
                objects.add(uploadNumber.get(index));
            }
            groupUploadNumber.add(objects);
        }


        List<Map<String, Object>> existsNumber = numberInfoMapper.isExistsNumber(groupUploadNumber);
        StringBuilder existsNums = new StringBuilder();
        List<Map<String, Object>> exclud = new ArrayList<Map<String, Object>>();

        StringBuffer existsNumberSb = new StringBuffer();

        for (Map<String, Object> map : existsNumber){
            existsNums.append(map.get("NUMBER"));
            map.put("","NUMBER");
            String phone = (String) map.get("NUMBER");

            existsNumberSb.append(phone).append(",");

        }

        if (CollectionUtils.isNotEmpty(existsNumber))
        {
            String tempStr = existsNumberSb.toString().substring(0, existsNumberSb.toString().length() - 1);
            logger.error("存在重复号码，禁止导入!");
            logger.error("重复号码为：" + tempStr);

            throw new DataException("0", "导入失败，存在重复号码：" + tempStr);
        }

        /*existsNumber.removeAll(exclud);

        if (0 < existsNumber.size()) {
            StringBuilder existsNum = new StringBuilder();
            for (Map<String, Object> map : existsNumber) {
                existsNum.append(map.get("NUMBER")).append(", ");
            }


            String message = "上传的手机号码中库中有已存在的号码[" + existsNum + "]";
            logger.error(message);
            throw new DataException("0", message);
        }*/

        try {
            return numberInfoMapper.insertBatch(listObjects);
        } catch (Exception e) {
            logger.error("文件检查成功，导入失败!", e);
            throw new DataException("0", "文件检查成功，导入失败!");
        }
    }
}

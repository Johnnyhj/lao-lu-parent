package com.ai.ge.platform.service.phonenum;

import com.ai.ge.platform.dto.number.NumberInfoDto;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.model.product.NumberInfo;

import java.io.InputStream;
import java.util.List;

/**
 * Created by guochunhao on 16/12/8.
 */
public interface PhoneNumService
{
    /**
     * 查询电话号码
     * @param count 需要获得的电话个数
     * @return
     */
    List<NumberInfo> findListBycount(int count,Long provinceAreaId,Long cityAreaId);

    /**
     * 使用电话号码
     * @param id 号码ID
     * @return
     */
    int occpyPhoneNumber(long id);

    /**
     * 根据条件查询号码 (管理台方法)
     * @param record
     * @return
     */
    List<NumberInfoDto> listNumberInfoDto(NumberInfoDto record);

    /**
     * 新增号码
     *
     * @param record
     * @return
     */
    int insertNumber(NumberInfo record);

    /**
     * 更新号码
     *
     * @param record
     * @param flag 是否参数检查标志
     *             true 检查
     *             fasle 不检查，主要是给页面更新状态使用
     * @return
     */
    int updateNumber(NumberInfo record, boolean flag);


    /**
     * 随机获取电话号码
     * @param count 需要获得的电话个数
     * @return
     */
    List<NumberInfo> findListRand(int count,Long provinceAreaId,Long cityAreaId);

    /**
     * 预占电话号码释放
     * @return
     */
    int releaseNumber(Long timeout);

    /**
     * 导入号码
     *
     * @param inputStream
     * @throws DataException
     */
    int batchAddNumber(InputStream inputStream) throws DataException;
}

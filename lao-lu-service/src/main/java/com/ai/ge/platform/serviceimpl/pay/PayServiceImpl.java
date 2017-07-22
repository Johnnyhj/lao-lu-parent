package com.ai.ge.platform.serviceimpl.pay;

import com.ai.ge.pay.weixin.wxpay.utils.MD5Util;
import com.ai.ge.platform.dto.order.OfferSpecDto;
import com.ai.ge.platform.mapper.order.OfferSpecMapper;
import com.ai.ge.platform.mapper.order.OrdersMapper;
import com.ai.ge.platform.mapper.order.OrdersPaymentMapper;
import com.ai.ge.platform.mapper.product.NumberInfoMapper;
import com.ai.ge.platform.model.order.OfferSpec;
import com.ai.ge.platform.model.order.Orders;
import com.ai.ge.platform.model.order.OrdersExample;
import com.ai.ge.platform.model.order.OrdersPayment;
import com.ai.ge.platform.model.product.NumberInfo;
import com.ai.ge.platform.model.product.NumberInfoExample;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.result.Result;
import com.ai.ge.platform.service.offerspec.OfferSpecService;
import com.ai.ge.platform.service.pay.PayService;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.serviceimpl.http.HttpRequestResult;
import com.ai.ge.platform.serviceimpl.pay.util.DESEncryptUtil;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by count on 17/5/19.
 */
@Service
public class PayServiceImpl implements PayService
{
    private Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private OrdersPaymentMapper ordersPaymentMapper;
    @Resource
    private OfferSpecMapper offerSpecMapper;

    public static final String PAY_DESKEY = "!Q@W#E$R%T^Y&U*I(!@#$%^";

    @Resource
    private NumberInfoMapper numberInfoMapper;

    @Resource
    private SysDataService sysDataService;

    @Resource
    private RedisSpringProxy redisService;

    @Resource
    protected OfferSpecService offerSpecService;

    @Override
    @Transactional
    public String pay(Long orderId,HttpServletRequest request) throws Exception{

        String rv = "";
        try {
            Orders order = ordersMapper.selectByPrimaryKey(orderId);

//            OfferSpecDto dto = null;
//            OfferSpec record = new OfferSpec();
//            record.setOfferSpecId(order.getOfferSpecId());
//            List<OfferSpecDto> list = offerSpecMapper.listBySelective(record);
//            if(list.size()>0){
//                dto = list.get(0);
//            }
            //获取订单套餐
            List<OfferSpecDto> list = new ArrayList<OfferSpecDto>();
            OfferSpecDto dto = null;
            String key = "AI-WEB_OFFERSPECDTO_BYOFFERSPECID_"+order.getOfferSpecId();
            OfferSpecDto offerSpecDto = redisService.read(key, OfferSpecDto.class);
            if(null!=offerSpecDto){
                list.add(offerSpecDto);
            }else{
                OfferSpec offerSpec = new OfferSpec();
                offerSpec.setOfferSpecId(order.getOfferSpecId());
                list = offerSpecService.findListByCond(offerSpec);
                if(list.size()>0)
                    redisService.save(key, list.get(0));
            }
            if(list.size()>0){
                dto = list.get(0);
            }else{
                logger.error("订单套餐不存在,支付异常。");
                rv = "failed";
            }

            String requestUrl = CommonUtil.getConfigValue("PAY_URL");//"http://zc.testpub.net/pay_platform_web/pay/to_pay_view.do";
            /*改为从数据库获取
            String appEncrypt = CommonUtil.getConfigValue("APPENCRYPT");//"2qiax5";
            String secret = CommonUtil.getConfigValue("UNIFY_PAY_SECRET");//"UZ82G949XCHGFCR5NERFUIO39UAA0J8CGRXJCJA";
            */
            String appEncrypt =null;
            String secret = null;

            key = "AI-WEB_PAY_APP_ENCRYPT_"+dto.getProvinceAearId();
            appEncrypt  = redisService.read(key,String.class);
            if(null==appEncrypt){
                appEncrypt = sysDataService.getByKeyType("pay_app_encrypt_"+dto.getProvinceAearId(),SysDataService.PAY,"");
                if(null!=appEncrypt&&!"".equalsIgnoreCase(appEncrypt))
                    redisService.save(key,appEncrypt);
            }
            if(null==appEncrypt||"".equalsIgnoreCase(appEncrypt)){
                logger.error("AppEncrypt不存在,支付异常。");
                rv = "failed";
            }

            key = "AI-WEB_PAY_APP_SECRET_"+dto.getProvinceAearId();
            secret  = redisService.read(key,String.class);
            if(null==secret){
                secret = sysDataService.getByKeyType("pay_app_secret_"+dto.getProvinceAearId(),SysDataService.PAY,"");
                if(null!=secret&&!"".equalsIgnoreCase(secret))
                    redisService.save(key,secret);
            }
            if(null==secret||"".equalsIgnoreCase(secret)){
                logger.error("Secret,支付异常。");
                rv = "failed";
            }

            secret = DESEncryptUtil.decrypt(secret, PAY_DESKEY);

            String currentTime = DateUtil.getCurrentYearMonthDayTime();
            // 支付参数
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("appEncrypt", appEncrypt); // 应用分配一个AppID的加密串
            String orderSeq = order.getOrderSeq();
            parameters.put("orderSeq", orderSeq); // 订单流水

            String price = order.getPayMoney().toString();
            DecimalFormat df = new DecimalFormat("0.00");
            String orderPrice = df.format(new BigDecimal(price));
            parameters.put("orderPrice", orderPrice); // 订单金额

            parameters.put("timestamp", currentTime); // 时间戳

            String staffId = "flowMarket";
            parameters.put("staffId", staffId);    // 员工号

            String channel = "营业厅";
            parameters.put("trafficHall",channel);// 营业厅

            String country = "sd";
            parameters.put("country", country);  // 区县
            String city = "jinan";
            parameters.put("city", city);     // 地市

            parameters.put("payGateway", "2");// 支付网关

            String deviceIp = CommonUtil.getRemortIp(request);
            parameters.put("deviceIp", deviceIp);  // 发起支付设备IP

            String prodDesc = dto.getName();
            parameters.put("prodDesc", prodDesc);// 商品名称（描述）

            String sign = MD5Util.MD5Encode(appEncrypt + secret + orderSeq + orderPrice + currentTime + staffId + channel + country + city + "2" + deviceIp + prodDesc, "UTF-8");
            parameters.put("sign", sign);// 签名校验

            MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
            HttpConnectionManagerParams params = new HttpConnectionManagerParams();
            params.setConnectionTimeout(10000);
            params.setSoTimeout(30000);

            httpConnectionManager.setParams(params);
            HttpClient httpClient = new HttpClient(httpConnectionManager);
            PostMethod method = new PostMethod(requestUrl);
            method.addParameter("appEncrypt", appEncrypt); // 应用分配一个AppID的加密串
            method.addParameter("orderSeq", orderSeq); // 订单流水
            method.addParameter("orderPrice", orderPrice); // 订单金额
            method.addParameter("timestamp", currentTime); // 时间戳
            method.addParameter("staffId", staffId);    // 员工号
            method.addParameter("trafficHall", channel);// 营业厅
            method.addParameter("country", country);  // 区县
            method.addParameter("city", city);     // 地市
            method.addParameter("payGateway", "2");// 支付网关
            method.addParameter("deviceIp", deviceIp);  // 发起支付设备IP
            method.addParameter("prodDesc", prodDesc);// 商品名称（描述）
            method.addParameter("sign", sign);// 签名校验

            try {
                method.getParams().setContentCharset("utf-8");
                httpClient.executeMethod(method);

                if (200 != method.getStatusCode()) {
                    //请求不成功处理
                    rv = "failed";
                }

                rv = new String(method.getResponseBody(), method.getResponseCharSet());

            }catch (IOException e) {
                method.releaseConnection();
                logger.error("支付异常。"+e.getMessage());
                rv = "failed";
            }finally{
                method.releaseConnection();
            }

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

        return rv;
    }

    @Override
    @Transactional
    public String payedCallback(Long orderId,String payResult){
        return null;
    }

    @Override
    @Transactional
    public void payedNotify(String orderSeq,
                       String payResult,
                       String orderPrice,
                       String payMessage,
                       String transactionId,
                       String gateway,
                       String sign, String pfOrderSeq){
        Date currentTime = new Date();




        //查询订单
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria().andOrderSeqEqualTo(orderSeq);
        List<Orders> orderList = ordersMapper.selectByExample(ordersExample);

        if(null!=orderList&&orderList.size()>0) {
            Orders order = orderList.get(0);
            //电话号码卖出状态2
            String tn = order.getTelPhone();
            NumberInfo numberInfo = new NumberInfo();
            numberInfo.setStatus(Short.parseShort("2"));
            numberInfo.setUpdateTime(new Date());
            NumberInfoExample numberInfoExample = new NumberInfoExample();
            numberInfoExample.createCriteria().andNumberEqualTo(tn);
            numberInfoMapper.updateByExampleSelective(numberInfo,numberInfoExample);

            // 写入订单支付明细表
            OrdersPayment ordersPayment = new OrdersPayment();
            ordersPayment.setOrderId(order.getOrderId());
            ordersPayment.setProdSaleAttrId(order.getProdSaleAttrId());
            ordersPayment.setOrderSeq(order.getOrderSeq());
            ordersPayment.setQuantity(order.getQuantity());
            ordersPayment.setPackageId(order.getOfferSpecId());//套餐id
            ordersPayment.setOrdersMoney(order.getOrdersMoney());
            ordersPayment.setExpressMoney(order.getExpressMoney());
            ordersPayment.setTotalMoney(order.getTotalMoney());
            ordersPayment.setPayType(Short.parseShort(gateway));//支付方式
            ordersPayment.setPayMoney(Float.parseFloat(orderPrice));//实际支付金额
            ordersPayment.setCustId(order.getCustId());
            ordersPayment.setCeateTime(currentTime);
            ordersPayment.setUpdateTime(currentTime);
            ordersPayment.setStatus((Short.parseShort(payResult)));//1.支付成功，0.支付失败
            ordersPayment.setOrderDescribe(payMessage);
            ordersPayment.setPaySeq(transactionId);
            ordersPayment.setPfOrderSeq(pfOrderSeq);
            ordersPaymentMapper.insertSelective(ordersPayment);

            //更新订单状态
            Orders recoder = new Orders();
            if(payResult.equalsIgnoreCase("1"))//支付成功
                recoder.setStatus(Short.parseShort("1"));
            else if(payResult.equalsIgnoreCase("0"))//支付失败
                recoder.setStatus(Short.parseShort("9"));

            recoder.setUpdateTime(currentTime);
            ordersExample = new OrdersExample();
            ordersExample.createCriteria().andOrderSeqEqualTo(orderSeq);
            ordersMapper.updateByExampleSelective(recoder,ordersExample);
        }
    }

    /**
     * 退款
     *
     * @param orderId 订单号
     * @param request 请求
     * @return 退款结果
     */
    @Override
    public ObjectResult refund(Long orderId, HttpServletRequest request) throws Exception
    {
        ObjectResult result = new ObjectResult();
        try {
            Orders order = ordersMapper.selectByPrimaryKey(orderId);

            // 只有未竣工状态的订单才能退款
            if (order.getStatus() != (short) 7)
            {
                result.setResultCode("1");
                result.setResultMsg("只支持未竣工状态的订单退款");

                return result;
            }

            OrdersPayment ordersPayment = new OrdersPayment();
            ordersPayment.setOrderId(orderId);
            ordersPayment.setStatus((short) 1);

            List<OrdersPayment> ordersPayments = ordersPaymentMapper.selectBySelective(ordersPayment);

            if (CollectionUtils.isEmpty(ordersPayments) || ordersPayments.size() > 1)
            {
                result.setResultCode("1");
                result.setResultMsg("支付明细存在异常, 不能退订!");

                return result;
            }

            ordersPayment = ordersPayments.get(0);

            // http://zc.testpub.net/pay_platform_web/pay/reFund.do
            String requestUrl = CommonUtil.getConfigValue("REFUND_URL");

            String key = "AI-WEB_PAY_APP_ENCRYPT_" + order.getProvinceAearId();
            String appEncrypt = redisService.read(key, String.class);

            if(StringUtils.isEmpty(appEncrypt)){

                appEncrypt = sysDataService.getByKeyType("pay_app_encrypt_" + order.getProvinceAearId(), SysDataService.PAY,"");
                redisService.save(key, appEncrypt);

            }

            if(StringUtils.isEmpty(appEncrypt)){
                logger.error("AppEncrypt不存在, 退款异常。");

                result.setResultCode("1");
                result.setResultMsg("AppEncrypt不存在, 退款异常。");

                return result;
            }

            key = "AI-WEB_PAY_APP_SECRET_" + order.getProvinceAearId();
            String secret  = redisService.read(key,String.class);
            if (StringUtils.isEmpty(secret))
            {
                secret = sysDataService.getByKeyType("pay_app_secret_" + order.getProvinceAearId(), SysDataService.PAY, "");
                redisService.save(key, secret);
            }

            if (StringUtils.isEmpty(secret)){
                logger.error("Secret不存在, 退款异常。");

                result.setResultCode("1");
                result.setResultMsg("Secret不存在, 退款异常。");

                return result;
            }

            secret = DESEncryptUtil.decrypt(secret, PAY_DESKEY);

            String currentTime = DateUtil.getCurrentYearMonthDayTime();

            // 退款参数
            Map<String, String> parameters = new HashMap<String, String>();

            // 应用分配一个AppID的加密串
            parameters.put("appEncrypt", appEncrypt);

            // 订单流水
            String orderSeq = order.getOrderSeq();
            parameters.put("orderSeq", orderSeq);

            // pfOrderSeq 平台支付流水号
            parameters.put("pfOrderSeq", ordersPayment.getPfOrderSeq());

            // refundOrderSeq 退款订单流水号 yyyyMMddHHmmss
            String refundOrderSeq = currentTime + CommonUtil.getCode(10);
            parameters.put("refundOrderSeq", refundOrderSeq);

            // 订单金额
            String price = order.getPayMoney().toString();
            DecimalFormat df = new DecimalFormat("0.00");
            String refundPrice = df.format(new BigDecimal(price));
            parameters.put("refundPrice", refundPrice);

            // 时间戳
            String timestamp = currentTime;
            parameters.put("timestamp", currentTime);

            // 员工号
            String staffId = "flowMarket";
            parameters.put("staffId", staffId);

            // 营业厅
            String trafficHall = "营业厅";
            parameters.put("trafficHall", trafficHall);

            // 区县 地市
            String country = "sd";
            parameters.put("country", country);
            String city = "jinan";
            parameters.put("city", city);

            // 发起支付设备IP
            String deviceIp = CommonUtil.getRemortIp(request);
            parameters.put("deviceIp", deviceIp);

            // Md5(appEncrypt+secret+orderSeq+ refundOrderSeq+refundPrice+timestamp+staffId+trafficHall+country+city+deviceIp)
            StringBuffer signOri = new StringBuffer();
            signOri.append(appEncrypt).append(secret).append(orderSeq).append(refundOrderSeq).append(refundPrice).append(timestamp).append(staffId).append(trafficHall).append(country).append(city).append(deviceIp);

            String sign = MD5Util.MD5Encode(signOri.toString(), "UTF-8");
            parameters.put("sign", sign);// 签名校验

            MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
            HttpConnectionManagerParams params = new HttpConnectionManagerParams();
            params.setConnectionTimeout(10000);
            params.setSoTimeout(30000);

            httpConnectionManager.setParams(params);
            HttpClient httpClient = new HttpClient(httpConnectionManager);
            PostMethod method = new PostMethod(requestUrl);

            Set<Map.Entry<String, String>> entrySet = parameters.entrySet();
            for (Map.Entry<String, String> entry : entrySet)
            {
                method.addParameter(entry.getKey(), entry.getValue());
            }

            try {
                method.getParams().setContentCharset("utf-8");
                httpClient.executeMethod(method);

                if (200 != method.getStatusCode()) {
                    result.setResultCode("1");
                    result.setResultMsg("请求不成功处理");

                    return result;
                }

                String resultPage = new String(method.getResponseBody(), method.getResponseCharSet());
                HttpRequestResult httpRequestResult = JSON.parseObject(resultPage, HttpRequestResult.class);

                if ("1".equals(httpRequestResult.getResultCode()))
                {
                    result.setResultCode("0");
                }
                else
                {
                    result.setResultCode(httpRequestResult.getResultCode());
                }

                result.setResultMsg(httpRequestResult.getResultMsg());

            } catch (IOException e) {
                method.releaseConnection();
                logger.error("退款异常，" + e.getMessage());

                result.setResultCode("1");
                result.setResultMsg("退款异常" + e.getMessage());

                return result;
            } finally {
                method.releaseConnection();
            }

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

        return result;
    }
}

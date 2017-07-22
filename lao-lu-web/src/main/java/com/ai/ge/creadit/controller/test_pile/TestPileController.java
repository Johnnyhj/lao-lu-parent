package com.ai.ge.creadit.controller.test_pile;

import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpRequestObject;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpRequestObject;
import com.ai.ge.util.DateUtil;
import com.ai.ge.util.RequestUtil;
import com.ai.ge.web.BaseController;
import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.commons.collections.CollectionUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 接口测试桩
 */

@Controller
@RequestMapping("/testpile")
public class TestPileController extends BaseController {


    /**
     * 页面授权
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/authorize")
    public void authorize(HttpServletRequest request, HttpServletResponse response) {

    }

    /**
     * 查询芝麻用户的芝麻信用评分
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/score")
    public void getScore(HttpServletRequest request, HttpServletResponse response) {

        String succResponseText = "{\n" +
                "  \"bizNo\": \"ZM201702153000000217600651746412\",\n" +
                "  \"body\": \"{\\\"biz_no\\\":\\\"ZM201702153000000217600651746412\\\",\\\"success\\\":true,\\\"zm_score\\\":\\\"666\\\"}\",\n" +
                "  \"params\": {\n" +
                "    \"params\": \"aaLMEIis5JHIOVqhd6P2peh+F4fPCPmZDumoHziExB+K7ypsNwj6c7w8psY2+wg1xUv5U7tt5V3XQELOHK8huxYU0wFmRy7QEXRcJHhymlfOUUGA0Oh19jNhV/hWN/bkTc99pOhNqne+6F/PIU7EjvgYw22CnlPjP9ERAnd6hkVKczK6Lub/W9y8I5NNZ3QfPWt7/etA3NWSJk450WjTxTCtot0htYOGMf1maOquytl7WHKJMGEUwX5tBULGVsLwDDWNQdGucPMp07gBg6b5Pbj7plI5DShuSQchG5uA8k9dlHGCEMfrfV+/D4DYfR03nzYjwujSpb77Tm61RZ7GlA==\"\n" +
                "  },\n" +
                "  \"success\": true,\n" +
                "  \"zmScore\": \"666\"\n" +
                "}";


        super.printJson(succResponseText, response);
    }


    /**
     * 单条数据反馈服务接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/single/feedback")
    public void testZhimaSingleFeedback(HttpServletRequest request, HttpServletResponse response) {
        String succResponseText = "{\n" +
                "  \"bizNo\": \"ZM201702153000000217600651746412\",\n" +
                "  \"body\": \"{\\\"biz_no\\\":\\\"ZM201702153000000217600651746412\\\",\\\"success\\\":true,\\\"zm_score\\\":\\\"666\\\"}\",\n" +
                "  \"params\": {\n" +
                "    \"params\": \"aaLMEIis5JHIOVqhd6P2peh+F4fPCPmZDumoHziExB+K7ypsNwj6c7w8psY2+wg1xUv5U7tt5V3XQELOHK8huxYU0wFmRy7QEXRcJHhymlfOUUGA0Oh19jNhV/hWN/bkTc99pOhNqne+6F/PIU7EjvgYw22CnlPjP9ERAnd6hkVKczK6Lub/W9y8I5NNZ3QfPWt7/etA3NWSJk450WjTxTCtot0htYOGMf1maOquytl7WHKJMGEUwX5tBULGVsLwDDWNQdGucPMp07gBg6b5Pbj7plI5DShuSQchG5uA8k9dlHGCEMfrfV+/D4DYfR03nzYjwujSpb77Tm61RZ7GlA==\"\n" +
                "  },\n" +
                "  \"success\": true,\n" +
                "  \"zmScore\": \"666\",\n" +
                "  \"openId\": \"07909449496\"\n" +
                "}";


        super.printJson(succResponseText, response);
    }

    /**
     * 批量数据反馈服务接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/batch/feedback")
    public void testZhimaBatchFeedback(HttpServletRequest request, HttpServletResponse response) {
        String succResponseText = "{\n" +
                "  \"bizNo\": \"ZM201702153000000217600651746412\",\n" +
                "  \"body\": \"{\\\"biz_no\\\":\\\"ZM201702153000000217600651746412\\\",\\\"success\\\":true,\\\"zm_score\\\":\\\"666\\\"}\",\n" +
                "  \"params\": {\n" +
                "    \"params\": \"aaLMEIis5JHIOVqhd6P2peh+F4fPCPmZDumoHziExB+K7ypsNwj6c7w8psY2+wg1xUv5U7tt5V3XQELOHK8huxYU0wFmRy7QEXRcJHhymlfOUUGA0Oh19jNhV/hWN/bkTc99pOhNqne+6F/PIU7EjvgYw22CnlPjP9ERAnd6hkVKczK6Lub/W9y8I5NNZ3QfPWt7/etA3NWSJk450WjTxTCtot0htYOGMf1maOquytl7WHKJMGEUwX5tBULGVsLwDDWNQdGucPMp07gBg6b5Pbj7plI5DShuSQchG5uA8k9dlHGCEMfrfV+/D4DYfR03nzYjwujSpb77Tm61RZ7GlA==\"\n" +
                "  },\n" +
                "  \"success\": true,\n" +
                "  \"zmScore\": \"666\",\n" +
                "  \"openId\": \"07909449496\"\n" +
                "}";


        super.printJson(succResponseText, response);
    }

    /**
     * 信用套餐查询接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/zhima/order/confirm")
    public void getOrderConfirm(HttpServletRequest request, HttpServletResponse response) {
//        String url = request.getParameter("redirecturl");

        String succResponseText = "{\n" +
                "  \"bizNo\": \"ZM201702153000000217600651746412\",\n" +
                "  \"body\": \"{\\\"biz_no\\\":\\\"ZM201702153000000217600651746412\\\",\\\"success\\\":true,\\\"zm_score\\\":\\\"666\\\"}\",\n" +
                "  \"params\": {\n" +
                "    \"params\": \"aaLMEIis5JHIOVqhd6P2peh+F4fPCPmZDumoHziExB+K7ypsNwj6c7w8psY2+wg1xUv5U7tt5V3XQELOHK8huxYU0wFmRy7QEXRcJHhymlfOUUGA0Oh19jNhV/hWN/bkTc99pOhNqne+6F/PIU7EjvgYw22CnlPjP9ERAnd6hkVKczK6Lub/W9y8I5NNZ3QfPWt7/etA3NWSJk450WjTxTCtot0htYOGMf1maOquytl7WHKJMGEUwX5tBULGVsLwDDWNQdGucPMp07gBg6b5Pbj7plI5DShuSQchG5uA8k9dlHGCEMfrfV+/D4DYfR03nzYjwujSpb77Tm61RZ7GlA==\"\n" +
                "  },\n" +
                "  \"name\": \"张三\",\n" +
                "  \"certNo\": \"301010198008088888\",\n" +
                "  \"openId\": \"07909449496\",\n" +
                "  \"zmScore\": \"666\",\n" +
                "  \"success\": true\n" +
                "}";


        super.printJson(succResponseText, response);
    }

    /**
     * 1.1.1.1	订单竣工查询接口
     *
     * @param request
     * @param response
     */
    @RequestMapping("/crm/complete")
    public void getCrmComplete(HttpServletRequest request, HttpServletResponse response) {
        String requestText = RequestUtil.readContent(request);
        System.out.println("订单竣工查询接口 " + requestText);

        CrmOrderCompleteHttpRequestObject httpRequestObject = JSON.parseObject(requestText, CrmOrderCompleteHttpRequestObject.class);


        List<Map<String, Object>> listObjects = new ArrayList<Map<String, Object>>();
        List<String> numbers = httpRequestObject.getNumbers();
        if (CollectionUtils.isNotEmpty(numbers)) {
            String s = numbers.get(0);

            Map<String, Object> numberMap = new HashMap<String, Object>();

            String date = DateUtil.getStrFromDate(new Date(), DateUtil.DATE_FORMATE_STRING_A);

            numberMap.put("phone_number", s);
            numberMap.put("ol_nbr", String.valueOf(System.currentTimeMillis()));
            numberMap.put("complate_time", date);
            numberMap.put("valid_time", date);
            numberMap.put("create_time", date);

            listObjects.add(numberMap);
        }


        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("result_code", "0");
//        objectMap.put("result_code", "1");
//        objectMap.put("result_msg", "this is error message");
        objectMap.put("object", listObjects);

        String responseTest = JSON.toJSONString(objectMap);

        printJson(responseTest, response);
    }



    @RequestMapping("/crm/complete/ws")
    public void getCrmCompletews(HttpServletResponse response)throws Exception{
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<queryCustInfoResponse>" +
                "<result>0</result>" +
                "<resultMsg>查询成功</resultMsg>" +
                "<prodOrderInfo >" +
                "<phone_number>18912345678</phone_number>" +
                "<ol_nbr>123321123</ol_nbr>" +
                "<complate_time>2017-06-13 13:33:09</complate_time >" +
                "<create_time>2017-06-13 13:33:09</create_time >" +
                "<valid_time>2017-06-13 13:33:09</valid_time >" +
                "</prodOrderInfo >" +
                "</queryCustInfoResponse>";

        String real = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <soapenv:Body>\n" +
                "      <queryOneCheckInfoResponse xmlns=\"http://crm.crmwsi\">\n" +
                "         <queryOneCheckInfoReturn><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><queryCustInfoResponse><result>1</result><resultMsg>查询号码不存在或已拆机，客户不存在或为非在用状态</resultMsg></queryCustInfoResponse>]]></queryOneCheckInfoReturn>\n" +
                "      </queryOneCheckInfoResponse>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

//        String f ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<queryCustInfoResponse>\n" +
//                "\t<result>1</result>\n" +
//                "\t<resultMsg>查询号码不存在或已拆机，客户不存在或为非在用状态</resultMsg>\n" +
//                "</queryCustInfoResponse>\n";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(real);
    }




    /**
     * 1.1.1.1	批量查询用户是否履约
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bill/performance/ws")
    public void getBillPerformancews(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String s = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <soapenv:Body>\n" +
                "      <ns1:accountBalanceQueryResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://server.web\">\n" +
                "         <accountBalanceQueryReturn href=\"#id0\"/>\n" +
                "      </ns1:accountBalanceQueryResponse>\n" +
                "      <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:AccountBalanceQueryResponse\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://po.web.com\">\n" +
                "         <result xsi:type=\"xsd:string\">0</result>\n" +
                "         <code xsi:type=\"xsd:string\"/>\n" +
                "         <msg xsi:type=\"xsd:string\"/>\n" +
                "         <accountBalanceSet soapenc:arrayType=\"ns2:AccountBalanceSetType[2]\" xsi:type=\"soapenc:Array\">\n" +
                "            <accountBalanceSet href=\"#id1\"/>\n" +
                "            <accountBalanceSet href=\"#id2\"/>\n" +
                "         </accountBalanceSet>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id2\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns3:AccountBalanceSetType\" xmlns:ns3=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">6514</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id1\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns4:AccountBalanceSetType\" xmlns:ns4=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">301</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(s);
    }


    /**
     * 1.1.1.1	批量查询用户是否履约
     *
     * @param request
     * @param response
     */
    @RequestMapping("/bill/performance")
    public void getBillPerformance(HttpServletRequest request, HttpServletResponse response) {
        String requestText = RequestUtil.readContent(request);
        System.out.println("批量查询用户是否履约 " + requestText);


        BillPerformanceHttpRequestObject httpRequestObject = JSON.parseObject(requestText, BillPerformanceHttpRequestObject.class);

        List<Map<String, Object>> listObjects = new ArrayList<Map<String, Object>>();
        List<String> numbers = httpRequestObject.getNumbers();

        String[] randomWord = new String[]{"Y", "N"};
        Random random = new Random();
        if (CollectionUtils.isNotEmpty(numbers)) {
            for (String number : numbers) {
                Map<String, Object> numberMap = new HashMap<String, Object>();

                numberMap.put("phone_number", number);
                numberMap.put("is_credit", randomWord[random.nextInt(2)]);
                numberMap.put("cost", "299");
                listObjects.add(numberMap);
            }

        }

        Map<String, Object> objectMap = new HashMap<String, Object>();
        objectMap.put("result_code", "0");
        objectMap.put("object", listObjects);

        String responseTest = JSON.toJSONString(objectMap);

        printJson(responseTest, response);
    }


    public static void main(String[] args) throws Exception{
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "   <soapenv:Body>\n" +
                "      <ns1:accountBalanceQueryResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://server.web\">\n" +
                "         <accountBalanceQueryReturn href=\"#id0\"/>\n" +
                "      </ns1:accountBalanceQueryResponse>\n" +
                "      <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:AccountBalanceQueryResponse\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://po.web.com\">\n" +
                "         <result xsi:type=\"xsd:string\">0</result>\n" +
                "         <code xsi:type=\"xsd:string\"/>\n" +
                "         <msg xsi:type=\"xsd:string\"/>\n" +
                "         <accountBalanceSet soapenc:arrayType=\"ns2:AccountBalanceSetType[2]\" xsi:type=\"soapenc:Array\">\n" +
                "            <accountBalanceSet href=\"#id1\"/>\n" +
                "            <accountBalanceSet href=\"#id2\"/>\n" +
                "         </accountBalanceSet>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id2\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns3:AccountBalanceSetType\" xmlns:ns3=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">6514</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "      <multiRef id=\"id1\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns4:AccountBalanceSetType\" xmlns:ns4=\"http://po.web.com\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "         <accountID xsi:type=\"xsd:string\">510015305564</accountID>\n" +
                "         <accountName xsi:type=\"xsd:string\">金彦君</accountName>\n" +
                "         <accountBalance xsi:type=\"xsd:string\">301</accountBalance>\n" +
                "         <expireDate xsi:type=\"xsd:string\"></expireDate>\n" +
                "         <balanceType xsi:type=\"xsd:string\">普通帐户余额</balanceType>\n" +
                "      </multiRef>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";


        XStream xStream = new XStream(new DomDriver());
        xStream.fromXML(s);

        System.out.println("TestPileController.main");

    }

}

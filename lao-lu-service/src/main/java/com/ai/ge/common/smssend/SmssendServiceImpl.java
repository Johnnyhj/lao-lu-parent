package com.ai.ge.common.smssend;

import com.ai.ge.common.smssend.bss.FaceResponse;
import com.ai.ge.platform.cache.SessionStoreCache;
import com.ai.ge.platform.model.sys.SystemAuthorization;
import com.ai.ge.platform.service.log.LogSmsSendService;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.util.RequestThreadLocal;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 *
 */
@Service
public class SmssendServiceImpl implements SmssendService {

    private static Logger log = Logger.getLogger(SmssendServiceImpl.class);

    @Resource
    private LogSmsSendService logSmsSendService;

    @Resource
    private SysDataService sysDataService;

//    @Resource(name = "webServiceProcessSmsSend")
//    private AbstractWebServiceProcess webServiceProcessSmsSend;


    @Override
    public FaceResponse sendSMS(String phoneNum, String content) {
        log.debug("[sendSMS] 开始发送短信 phone：" + phoneNum + " content: " + content);

        try {
            HttpSession session = RequestThreadLocal.getHttpThreadWrapper().getRequest().getSession();
            SystemAuthorization systemAuthorization = (SystemAuthorization) session.getAttribute(SessionStoreCache
                    .SESSION_USER);


//            OrderContext orderContext = new OrderContext();
//            orderContext.setSystemAuthorization(systemAuthorization);
//            orderContext.setProcessName(WebServiceProcess.SEND_SMS);
//
//            //WebServiceProcessFactory.getQueryCallVal(orderContext, "offerSpecIds");
//
//            WebServiceContext webServiceContext = new WebServiceContext();
//            webServiceProcessSmsSend.process(webServiceContext);


            logSmsSendService.saveLogSmsSend(phoneNum, content, null);

            log.debug("[sendSMS] 发送短信成功 phone：" + phoneNum);
            return null;
        } catch (Exception e) {
            log.debug("[sendSMS] 发送短信异常 phone：" + phoneNum);
            return null;
        }
    }
}
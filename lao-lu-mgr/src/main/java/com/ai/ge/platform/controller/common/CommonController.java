package com.ai.ge.platform.controller.common;

import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.platform.service.user.UserService;
import com.ai.ge.platform.serviceimpl.user.PasswordHelper;
import com.ai.ge.util.CommonUtil;
import com.ai.ge.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共服务控制器
 */

@Controller
@RequestMapping("/out")
public class CommonController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    // 存放验证码对应的key值
    private String code_key = "MARKET_CODE_KEY";
    private String code_num = "MARKET_CODE_NUM";

    @Resource
    private SysDataService sysDataService;

    @Resource
    private RedisSpringProxy redisService;

    @Resource
    private UserService userService;

    @Resource
    private PasswordHelper passwordHelper;

    /**
     * 上传图片资源
     *
     * @param response
     */
    @RequestMapping("/uploader")
    public void uploader(@RequestParam("uploadfile") CommonsMultipartFile uploadfile, String page,
                         HttpServletResponse response) {
        String uploaderDirectory = sysDataService.getByKeyType("mgrApp.uploader_directory", SysDataService.MGR_APP, "/");

        String path = DateUtil.getStrFromDate(new Date(), "yyyyMM");

        // 没有指定调用本方法的页面标识
        if (StringUtils.isBlank(page)) {
            super.printJson(new ObjectResult("0", "没有指定调用本方法的页面标识，没有page参数"), response);
            return;
        }

        page += '/' + page;

        uploaderDirectory += '/' + path;

        File file = new File(uploaderDirectory);
        if (!file.exists()) {
            file.mkdirs();
        }

        logger.debug("[uploadFile] 上传单个文件开始");

        logger.debug("[uploadFile] 上传文件的页面page = " + page);

        try {
            logger.debug("[uploadFile] 本地存储路径path = " + path);

            // 生成指定路径和指定名称的文件

            // 获取当前时间的毫秒表示，作为文件名
            long countNumber = System.currentTimeMillis();
            // 获取当前上传文件的后缀名
            String suffix = uploadfile.getFileItem().getName().substring(uploadfile.getFileItem().getName()
                    .lastIndexOf("."));

            String fileName = countNumber + suffix;

            File uploaderFile = new File(uploaderDirectory, fileName);

            uploadfile.getFileItem().write(uploaderFile);

            Map<String, Object> result = new HashMap<String, Object>();

            result.put("fileName", "/image/" + path + '/' + fileName);

            ObjectResult objectResult = new ObjectResult();

            objectResult.setObject(result);
            super.printJson(objectResult, response);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.debug("[uploadFile] 上传单个文件出错，错误信息：" + e.toString());
        }
        logger.debug("[uploadFile] 上传单个文件结束");
    }

    /**
     * 短信验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getCode.do", method = RequestMethod.POST)
    public void getCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ObjectResult objectResult = new ObjectResult();
        String phone = request.getParameter("phone");

        if (StringUtils.isEmpty(phone)) {
            objectResult.setResultCode("1011");
            objectResult.setResultMsg("请输入手机号!");
            printJson(objectResult, response);
            return;
        }

        String objectCode = redisService.read(code_key + phone + "TIME", String.class);
        if (StringUtils.isNotBlank(objectCode)) {
            objectResult.setResultCode("1012");
            objectResult.setResultMsg("发送验证码频繁");
            printJson(objectResult, response);
            return;
        }

        String code = CommonUtil.genRandomNum(4);

        session.setAttribute(code_key + phone + "TIME", System.currentTimeMillis());

        redisService.saveEx(code_key + phone + "TIME", 59, code);


        String smsTmp = sysDataService.getByKeyType("sms_tmp", "mgrApp");
        if (null != smsTmp) {
            MessageFormat format = new MessageFormat(smsTmp);
            String[] args = new String[]{code};
            smsTmp = format.format(args);
        }

        logger.debug("smsTmp:" + smsTmp);

        objectResult.setResultMsg(smsTmp);
        session.setAttribute(code_key + phone, code);

        // 以下这段代码先屏蔽,作为页面调测时使用,后续放开
        /*FaceResponse resp = new FaceResponse();
        try {
            resp = smssendService.sendSMS(phone, smsTmp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


        if (null == resp || !"0".equals(resp.getResult())) {
            objectResult.setResultCode("1011");
            objectResult.setResultMsg("发送验证码失败");
            session.removeAttribute(code_key + phone + "TIME");
        } else {
            session.setAttribute(code_key + phone, code);// redisService.saveEx(code_key
            // + phone, 600,
            // "1234");
        }*/
        printJson(objectResult, response);

    }

    /**
     * 校验短信验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/validateCode.do", method = RequestMethod.POST)
    public void validateCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ObjectResult objectResult = new ObjectResult();

        String phone = request.getParameter("telPhone");
        String code = request.getParameter("validateCode");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(phone + code + password))
        {
            objectResult.setResultCode("98");
            objectResult.setResultMsg("输入框中请输入具体值!");
            printJson(objectResult, response);
            return;
        }

        String msgCode = (String) session.getAttribute(code_key + phone);// redisService.read(code_key
        // +
        // phone,String.class);
        Long time = (Long) session.getAttribute(code_key + phone + "TIME");

        // 手机验证码有效时间（分）
        String authCodeTime = sysDataService.getByKeyType("market.authCode.time", SysDataService.WEB_APP, "10");
        if (null == authCodeTime) {
            authCodeTime = "10";
        }

        // 验证码不存在
        if (StringUtils.isEmpty(msgCode)) {
            objectResult.setResultCode("1001");
            objectResult.setResultMsg("验证码不存在");
            printJson(objectResult, response);
            return;
        } else if (!msgCode.equalsIgnoreCase(code)) {
            // 验证码错误
            // 尝试次数，超过5次时验证码失效
            Integer num = (Integer) session.getAttribute(code_num + phone);// redisService.read(code_num
            // +
            // phone,Integer.class);
            if (null == num) {
                num = 1;
            } else {
                num++;
            }
            objectResult.setResultCode("1002");
            objectResult.setResultMsg("验证码错误，已经尝试" + num + "次");

            if (num >= 5) {
                objectResult.setResultCode("1003");
                objectResult.setResultMsg("验证码失效");
                session.removeAttribute(code_key + phone);// redisService.delete(code_num
                // + phone);
                session.removeAttribute(code_num + phone);
            } else {
                session.setAttribute(code_num + phone, num);// redisService.saveEx(code_num
                // + phone, 600,
                // num);
            }

            printJson(objectResult, response);
            return;
        } else if (System.currentTimeMillis() - time > Integer.parseInt(authCodeTime) * 60000) {
            objectResult.setResultCode("1004");
            objectResult.setResultMsg("验证码超时");
            session.removeAttribute(code_key + phone);
            session.removeAttribute(code_num + phone);
            printJson(objectResult, response);
            return;
        }

        // 根据手机号修改账号密码
        try {
            userService.changePasswordByPhone(phone, password);
        } catch (DataException e) {
            objectResult.setResultCode("99");
            objectResult.setResultMsg(e.getMessage());
        }

        objectResult.setResultMsg("修改密码成功!");
        printJson(objectResult, response);

    }

}

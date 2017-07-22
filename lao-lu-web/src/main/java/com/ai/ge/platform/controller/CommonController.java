package com.ai.ge.platform.controller;

import com.ai.ge.platform.result.ObjectResult;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.util.DateUtil;
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
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Resource
    private RedisSpringProxy redisService;

    @Resource
    private SysDataService sysDataService;

    public String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }

    /**
     * 上传图片资源
     *
     *  @param response
     */
    @RequestMapping("/uploader")
    public void uploader(@RequestParam("uploadfile") CommonsMultipartFile uploadfile, HttpServletResponse response, HttpServletRequest request)
    {
        // 绝对路径  到webapps目录
        String uploaderDirectory = sysDataService.getByKeyType("mgrApp.uploader_directory", SysDataService.MGR_APP, "/");

        String path = DateUtil.getStrFromDate(new Date(), "yyyyMM");

        uploaderDirectory += '/' + path;

        File file = new File(uploaderDirectory);
        if (!file.exists()) {
            file.mkdirs();
        }

        logger.debug("[uploadFile] 上传单个文件开始");

        try {
            logger.debug("[uploadFile] 本地存储路径path = " + path);

            // 生成指定路径和指定名称的文件

            // 获取当前时间的毫秒表示，作为文件名
            long countNumber = System.currentTimeMillis();

            // 获取当前上传文件的后缀名
            String suffix = uploadfile.getFileItem().getName().substring(uploadfile.getFileItem().getName().lastIndexOf("."));

            String fileName = countNumber + suffix;

            File uploaderFile = new File(uploaderDirectory, fileName);

            uploadfile.getFileItem().write(uploaderFile);

            Map<String, Object> result = new HashMap<String, Object>();

            result.put("fileName", "/image/" + path + "/" + fileName);

            ObjectResult objectResult = new ObjectResult();

            objectResult.setObject(result);
            super.printJson(objectResult, response);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.debug("[uploadFile] 上传单个文件出错，错误信息：" + e.toString());

            super.printJson(ObjectResult.getErrorObjectResult("上传图片失败!"), response);
        }
        logger.debug("[uploadFile] 上传单个文件结束");
    }


    /**
     * 清理Redis缓存
     */
    @RequestMapping(value = "/flushAll", method = {RequestMethod.GET, RequestMethod.POST})
    public void flushAll(HttpServletResponse response)
    {
        redisService.flushAll();
        printJson(new ObjectResult(), response);
    }
}

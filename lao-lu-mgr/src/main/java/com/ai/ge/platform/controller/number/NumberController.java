package com.ai.ge.platform.controller.number;

import com.ai.ge.platform.controller.common.BaseController;
import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.result.Result;
import com.ai.ge.platform.service.phonenum.PhoneNumService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Created by guochunhao on 17/5/29.
 */
@Controller
public class NumberController extends BaseController
{
    private Logger logger = LoggerFactory.getLogger(NumberController.class);

    @Resource
    private PhoneNumService phoneNumService;

    @RequestMapping("/importNumber")
    public void uploadContractNumber(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {

        Result result = new Result();
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext()) {
            MultipartFile mpfile = request.getFile(iterator.next());

            try {
                int resultInt = phoneNumService.batchAddNumber(mpfile.getInputStream());

                result = new Result("1", "成功导入" + resultInt + "条号码!");

            } catch (DataException e) {
                result = new Result("0", e.getMessage());
                writer.print(JSONObject.fromObject(result).toString());
                return;
            } catch (Exception e) {
                result = new Result("0", StringUtils.isEmpty(e.getMessage()) ? String.valueOf(e) : e.getMessage());
                writer.print(JSONObject.fromObject(result).toString());
                return;
            }
        }

        result.setResultCode("1");
        writer.print(JSONObject.fromObject(result).toString());
    }
}

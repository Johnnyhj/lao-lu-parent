package com.ai.ge.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * 模板工具类
 */
public class TemplateUtil {

    private static Logger logger = LoggerFactory.getLogger(TemplateUtil.class);

    public static String getTemplateText(String templateText, Map<String, Object> params) {
        StringWriter sw = null;
        try {
            Template template = new Template(null, new StringReader(templateText), null, CharEncoding.UTF_8);
            sw = new StringWriter();
            template.process(params, sw);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);

            throw new RuntimeException(e);
        } catch (TemplateException e) {
            logger.error(e.getMessage(), e);

            throw new RuntimeException(e);
        }

        String s = sw.toString();

        return s;
    }


}

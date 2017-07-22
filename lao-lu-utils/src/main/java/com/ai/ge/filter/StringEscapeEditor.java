package com.ai.ge.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.beans.PropertyEditorSupport;

/**
 * 过滤敏感字符
 */
public class StringEscapeEditor extends PropertyEditorSupport {

    private boolean escapeHtml;
    private boolean escapeJavaScript;

    public StringEscapeEditor(boolean escapeHtml, boolean escapeJavaScript) {
        this.escapeHtml = escapeHtml;
        this.escapeJavaScript = escapeJavaScript;
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return null != value ? value.toString() : "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isNotBlank(text)) {
            if (escapeHtml) {
                //Html字符过滤
                text = HtmlUtils.htmlEscape(text);
            }

            if (escapeJavaScript) {
                //JavaScript脚本字符过滤
                text = JavaScriptUtils.javaScriptEscape(text);
            }
            setValue(text);
        }
    }
}

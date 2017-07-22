package com.ai.ge.util;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XML与对象互转，对象实例通过XStream中的@XStreamAlias进行映射
 */
public class XmlObjectTransformUtils {
    /**
     * xml转对象实例
     *
     * @param xmlText
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T transform(String xmlText, Class<T> clazz) {

        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(clazz);
        xs.ignoreUnknownElements();
        try {
            return (T) xs.fromXML(xmlText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 对象实例转xml
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String transform(T t) {
        XStream xs = new XStream(new DomDriver());
        xs.processAnnotations(t.getClass());

        try {
            return xs.toXML(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

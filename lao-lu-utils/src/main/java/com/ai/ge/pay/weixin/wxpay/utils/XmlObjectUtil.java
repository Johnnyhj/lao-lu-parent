package com.ai.ge.pay.weixin.wxpay.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class XmlObjectUtil {
private static Logger log = Logger.getLogger(XmlObjectUtil.class);
	
	static public String fromObjectToXML(Class<?> c,Object xmlBean) throws Exception{
		String xmlString = "";
		try{			
			JAXBContext jaxbContext = JAXBContext.newInstance(c);  
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //是否格式化生成的xml串
	        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");  //编码格式
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);//是否省略xml头信息
	        
	        StringWriter swriter=new StringWriter();  
	        jaxbMarshaller.marshal(xmlBean, swriter);  //将XML内容打印为字符串
	        xmlString=swriter.getBuffer().toString();
	        
//	        xmlString = xmlString.replaceAll ( "\r",  "" );   
//	        xmlString = xmlString.replaceAll ( "\n",  "");
//	        xmlString = xmlString.replace(" ", "");
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return xmlString;
	}
	
	static public Object fromXMLToObject(Class<?> c,String xml) throws Exception{
		Object reObj= null;
		try{			
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller um = context.createUnmarshaller();
			reObj = um.unmarshal(new StringReader(xml));
			
			if (log.isDebugEnabled())
	        {
	            log.debug("XML转换对象:");
	            log.debug(JackJson.fromObjectToJson(JackJson.fromObjectToJson(reObj)));
	        }
//	        xmlString = xmlString.replaceAll ( "\r",  "" );   
//	        xmlString = xmlString.replaceAll ( "\n",  "");
//	        xmlString = xmlString.replace(" ", "");
	        
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return reObj;
	}
}

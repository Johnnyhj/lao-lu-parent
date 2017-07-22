package com.ai.ge.common;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: CustomObjectMapper
 * @Description: 解决Date类型返回json格式为自定义格式
 * @author zhimingyou
 * @date 2015年9月24日 上午9:38:51
 * 
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen,SerializerProvider provider) throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String formattedDate = formatter.format(value);

		jgen.writeString(formattedDate);

	}

}

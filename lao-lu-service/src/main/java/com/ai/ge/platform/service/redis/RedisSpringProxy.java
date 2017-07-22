/**
 * 
 */
package com.ai.ge.platform.service.redis;

/**
 * @author ch
 *
 */
import com.ai.ge.platform.model.product.NumberInfo;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisSpringProxy {
	
	void save(final String key, final Object value);
	void saveEx(final String key, final long expireTime, final Object value) ;
	<T> T read(final String key, final Class<T> clazz, final Class... elementClasses) ;
	Long delete(final String key);
	Boolean hSet(final String key, final Object field, final Object value);
	<T> T hGet(final String key, final Object field, final Class<T> clazz, final Class... elementClasses) ;
	void hmSet(final String key, final Map<Object, Object> mapObject) ;
	//List<Object> hmGet(final String key, final Object... field);
	//Map<Object, Object> hGetAll(final String key);
	Boolean hDel(final String key, final String field);
	Long hLen(final String key) ;
	Set<String> hKeys(final String key) ;
	Long lPush(final String key, final Object... values);

    Long rPush(String key, Object... values);

    //List<Object> lRange(final String key, final long begin, final long end);
	<T> T lPop(final String key, final Class<T> clazz, final Class... elementClasses) ;
	<T> T rPop(final String key, final Class<T> clazz, final Class... elementClasses);

	void sRem(final String key, final Object... value);
	void sAdd(final String key, final Object... value);
	List sRandMember(final String key, final Long number, final Class clazz, final Class... elementClasses);
	Long sCard(final String key);

    void flushAll();

}


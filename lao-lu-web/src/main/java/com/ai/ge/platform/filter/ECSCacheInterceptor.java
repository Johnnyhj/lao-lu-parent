package com.ai.ge.platform.filter;

import com.ai.ge.cache.KeyGenerator;
import com.ai.ge.cache.annotation.CacheOperate;
import com.ai.ge.cache.annotation.ECSCache;
import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.CommonUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 缓存方法拦截器核心代码
 * 
 * @author zhaochangyun
 * 
 */
public class ECSCacheInterceptor implements MethodInterceptor
{
    /**
     * 日志记录器
     */
    private static final Logger log = Logger.getLogger(ECSCacheInterceptor.class);

    //@Resource
    private RedisSpringProxy redisService;

    /**
     * 方法拦截，当拦截到该方法有ECSCache注解时，则使用缓存数据
     */
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        Object result = null;
        ECSCache ecsCache = invocation.getMethod().getAnnotation(ECSCache.class);
        if (null != ecsCache)
        {
            if (null == redisService)
            {
                redisService = CommonUtil.APPLICATION_CONTEXT.getBean(
                        "redisSpringProxy", RedisSpringProxy.class);
            }

            String key = ecsCache.prefix() + "_:";
            key += getCacheKey(invocation, ecsCache.key());
            // PageContext pageContext = PageContext.getContext();
            // if (null != pageContext)
            // {
            // key += "_page_" + pageContext.getCurrentPage();
            // }

            if (CacheOperate.REMOVE.equals(ecsCache.operate()))
            {
                // 删除缓存
                redisService.delete(ecsCache.prefix() + "*");
                // 调用实际的方法
                result = invocation.proceed();
                return result;
            }
            else if (CacheOperate.PUT.equals(ecsCache.operate()))
            {
                // 更新缓存内容
                // 删除缓存
                redisService.delete(key);
                // 调用实际的方法
                result = invocation.proceed();

                redisService.save(key, result);

                return result;
            }
            else if (CacheOperate.GET.equals(ecsCache.operate()))
            {
                result = getCache(key, invocation.getMethod());
                if (result == null)
                {
                    // 没有获取到缓存数据
                    // 则调用相应的方法，并添加到缓存
                    // 调用实际的方法
                    result = invocation.proceed();
                    // 添加数据到相应的缓存
                    redisService.save(key, result);
                    // if (null != pageContext)
                    // {
                    // putCache(ecsCache.prefix() + "_page_object", pageContext,
                    // ecsCache);
                    // }
                }
                return result;
            }

        }

        // 调用实际的方法
        result = invocation.proceed();
        return result;
    }

    /**
     * 缓存 获取数据
     * 
     * @param key
     * @param method
     * @return
     * @throws Throwable
     */
    private Object getCache(String key, Method method) throws Throwable
    {

        Type returnType = method.getGenericReturnType();// 返回类型
        // 如果是泛型类型
        if (returnType instanceof ParameterizedType)
        {
            // 泛型类型列表
            Type[] elementClasses = ((ParameterizedType) returnType).getActualTypeArguments();
            Class collectionClass = (Class) ((ParameterizedType) returnType).getRawType();
            if (elementClasses == null || elementClasses.length == 0)
            {
                return redisService.read(key, collectionClass);
            }
            else if (elementClasses.length == 1)
            {
                return redisService.read(key, collectionClass, (Class) elementClasses[0]);
            }
            else
            {
                return redisService.read(key, collectionClass, (Class) elementClasses[0], (Class) elementClasses[1]);
            }
        }
        else
        {
            return redisService.read(key, (Class) returnType);
        }

    }

    /**
     * 返回具体的方法全路径名称 参数
     * 
     * @param invocation
     * @param key
     * @return
     * @throws Exception
     */
    private String getCacheKey(MethodInvocation invocation, String key) throws Exception
    {
        if (null == key || "".equals(key.trim()))
        {
            Object[] arguments = invocation.getArguments();
            String _key = KeyGenerator.keyGenerator(arguments);
            if (_key.endsWith(":"))
            {
                _key = _key.substring(0, _key.length() - 1);
            }
            return _key;
        }
        else
        {
            return key;
        }
    }
}
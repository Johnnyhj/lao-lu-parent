package com.ai.ge.cache.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ECS缓存注解
 * 
 * @author zhaochangyun
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ECSCache
{

    /**
     * 缓存key值表达式
     * 
     * @return
     */
    String key() default "";

    /**
     * 前缀
     * 
     * @return
     */
    String prefix() default "";

    /**
     * 缓存操作
     * 
     * @return
     */
    CacheOperate operate() default CacheOperate.GET;
}

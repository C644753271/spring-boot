package com.duqio.boot.cache.jcache.autoconfigure.matchremove;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 *************************************************
 * 功能描述:  用于移除缓存                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年3月8日 创建文件                                             
 * @see                        
 *************************************************
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface CacheRemove {

	/** 定义要操作的缓存名 **/
	String value() default "";
	
	/** 多种缓存Key的正则表达式 **/
    String[] key() default{};
	
}

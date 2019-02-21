package com.duqio.boot.core.exception;


/**
 * 
 *************************************************
 * 功能描述:  异常的抛出工具类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2018年11月8日 创建文件                                             
 * @see                        
 *************************************************
 */
public final class ThrowsException {

	/**
	 * 抛出自定义异常码和异常消息
	 * @param errorMessage
	 * @param errorCode
	 * @return
	 */
	public static final BaseException throwEx(String errorMessage, int errorCode) {
		throw new BaseException(errorCode, errorMessage);
	}
	
	/**
	 * 给定异常消息并抛出异常
	 * @param errorMessage
	 * @return
	 */
	public static final BaseException throwEx(String errorMessage) {
		throw new BaseException(errorMessage);
	}
	
}

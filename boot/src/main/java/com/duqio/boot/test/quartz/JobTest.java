package com.duqio.boot.test.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 *************************************************
 * 功能描述:  定义Job                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月19日 创建文件                                             
 * @see                        
 *************************************************
 */
@DisallowConcurrentExecution //不允许在不同服务器上并发执行
public class JobTest extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("执行了Job");
	}

}

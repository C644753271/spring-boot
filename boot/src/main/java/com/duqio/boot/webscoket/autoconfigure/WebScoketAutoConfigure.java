package com.duqio.boot.webscoket.autoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yeauty.standard.ServerEndpointExporter;

/**
 * 
 *************************************************
 * 功能描述:  webScoket的自动配置类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月26日 创建文件                                             
 * @see                        
 *************************************************
 */
@Configuration
public class WebScoketAutoConfigure {

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
}

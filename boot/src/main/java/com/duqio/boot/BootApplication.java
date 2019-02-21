package com.duqio.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.duqio.boot.orm.jpa.repository.BaseRepositoryImpl;

/**
 * 
 *************************************************
 * 功能描述:  应用程序主入口                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月19日 创建文件                                             
 * @see                        
 *************************************************
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}

package com.duqio.boot.test.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.duqio.boot.test.persistence.UserPersistence;

/**
 * 
 *************************************************
 * 功能描述:  jdbc持久化接口                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月19日 创建文件                                             
 * @see                        
 *************************************************
 */
@Repository
public class UserPersistenceImpl implements UserPersistence {

	@SuppressWarnings("unused")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public UserPersistenceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
}

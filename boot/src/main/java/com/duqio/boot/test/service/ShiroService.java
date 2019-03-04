package com.duqio.boot.test.service;

import com.duqio.boot.core.exception.BaseException;
import com.duqio.boot.test.entity.ShiroUser;

public interface ShiroService {

	/**
	 * 注册用户
	 * @param shiroUser
	 * @return
	 * @throws BaseException
	 */
	boolean addShiroUserService(ShiroUser shiroUser) throws BaseException;
	
	/**
	 * 根据用户名和密码进行登录
	 * @param shiroUser
	 * @return
	 * @throws BaseException
	 */
	ShiroUser findShiroUserByUserNameAndPassword(ShiroUser shiroUser) throws BaseException;
	
	/**
	 * 根据用户名或者到用户的信息
	 * @param userName
	 * @return
	 * @throws BaseException
	 */
	ShiroUser findShiroUserByUserName(String userName) throws BaseException;
}

package com.duqio.boot.test.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.duqio.boot.core.exception.BaseException;
import com.duqio.boot.test.entity.User;

public interface UserService {

	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws BaseException
	 */
	boolean addUserService(User user) throws BaseException;
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws BaseException
	 */
	boolean modUserService(User user) throws BaseException;
	
	/**
	 * 分页获取到数据
	 * @param pageable
	 * @return
	 * @throws BaseException
	 */
	List<User> findUserByPageable(Pageable pageable) throws BaseException;
	
	/**
	 * 根据编号获取到用户的数据
	 * @param user
	 * @return
	 * @throws BaseException
	 */
	User findUserByUserId(User user) throws BaseException;
}

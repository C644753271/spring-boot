package com.duqio.boot.test.repository;

import org.springframework.stereotype.Repository;

import com.duqio.boot.orm.jpa.repository.BaseRepository;
import com.duqio.boot.test.entity.ShiroUser;

@Repository
public interface ShiroRepository extends BaseRepository<ShiroUser, Integer>{

	/**
	 * 根据用户名和密码来获取到用户的信息
	 * @param shiroUsername
	 * @param shiroPassword
	 * @return
	 */
	ShiroUser findByShiroUsernameAndShiroPassword(String shiroUsername, String shiroPassword);
	
	/**
	 * 根据用户名获取到用户的信息
	 * @param shiroUsername
	 * @return
	 */
	ShiroUser findByShiroUsername(String shiroUsername);
	
}

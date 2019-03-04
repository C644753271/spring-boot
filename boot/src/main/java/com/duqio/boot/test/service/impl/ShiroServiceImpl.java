package com.duqio.boot.test.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duqio.boot.core.exception.BaseException;
import com.duqio.boot.test.entity.ShiroUser;
import com.duqio.boot.test.repository.ShiroRepository;
import com.duqio.boot.test.service.ShiroService;

@Service
public class ShiroServiceImpl implements ShiroService {

	private ShiroRepository shiroRepository;

	@Autowired
	public ShiroServiceImpl(ShiroRepository shiroRepository) {
		super();
		this.shiroRepository = shiroRepository;
	}

	@Override
	public boolean addShiroUserService(ShiroUser shiroUser) throws BaseException {
		ShiroUser entity = shiroRepository.saveAndFlush(shiroUser);
		if(Objects.isNull(entity) || Objects.isNull(entity.getShiroId()))
			throw new BaseException("添加失败");
		return true;
	}

	@Override
	public ShiroUser findShiroUserByUserNameAndPassword(ShiroUser shiroUser) throws BaseException {
		ShiroUser result = shiroRepository.findByShiroUsernameAndShiroPassword(shiroUser.getShiroUsername(), shiroUser.getShiroPassword());
		//此处省略判断
		return result;
	}

	@Override
	public ShiroUser findShiroUserByUserName(String userName) throws BaseException {
		ShiroUser result = shiroRepository.findByShiroUsername(userName);
		return result;
	}
	
	
	
}

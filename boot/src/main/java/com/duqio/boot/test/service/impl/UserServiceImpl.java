package com.duqio.boot.test.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duqio.boot.core.exception.BaseException;
import com.duqio.boot.core.exception.ThrowsException;
import com.duqio.boot.test.entity.User;
import com.duqio.boot.test.persistence.UserPersistence;
import com.duqio.boot.test.repository.UserRepository;
import com.duqio.boot.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	/** jpa持久化接口 **/
	private UserRepository userRepository;
	
	/** jdbc持久化接口 **/
	@SuppressWarnings("unused")
	private UserPersistence userPersistence;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserPersistence userPersistence) {
		super();
		this.userRepository = userRepository;
		this.userPersistence = userPersistence;
	}

	@CacheEvict(value = "user", allEntries = true)
	@Transactional
	@Override
	public boolean addUserService(User user) throws BaseException {
		User entity = userRepository.saveAndFlush(user);
		if(Objects.isNull(entity.getUserId()))
			throw new BaseException("添加失败");
		return true;
	}

	@CacheEvict(value = "user", allEntries = true)
	@Transactional
	@Override
	public boolean modUserService(User user) throws BaseException {
		Optional<User> optionalResult = userRepository.findById(user.getUserId());
		User oldResult = optionalResult.orElseThrow(() -> ThrowsException.throwEx("没有查询到对应数据"));
		//User oldResult = optionalResult.get();
		oldResult.setUserName(user.getUserName());
		User entity = userRepository.saveAndFlush(oldResult);
		if(Objects.isNull(entity.getUserId()))
			throw new BaseException("添加失败");
		return true;
	}

	@Cacheable(value = "user", key = "#root.methodName + '_' + #pageable.getPageNumber()")
	@Override
	public List<User> findUserByPageable(Pageable pageable) throws BaseException {
		List<User> results = userRepository.findAll(pageable).getContent();
		if(results.size() <= 0)
			throw new BaseException("没有更多数据了");
		return results;
	}

	@Cacheable(value = "user", key = "#root.methodName + '_' + #user.userId.intValue()")
	@Override
	public User findUserByUserId(User user) throws BaseException {
		Optional<User> optionalResult = userRepository.findById(user.getUserId());
		User result = optionalResult.orElseThrow(() -> ThrowsException.throwEx("没有查询到对应数据"));
		//User result = optionalResult.get();
		return result;
	}
	
}

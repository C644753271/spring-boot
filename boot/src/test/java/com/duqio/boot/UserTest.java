package com.duqio.boot;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.duqio.boot.test.entity.User;
import com.duqio.boot.test.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findUserByPageable() {
		Supplier<Pageable> supplier = () -> {
			Sort sort = new Sort(Direction.DESC, "userId");
			Pageable pageable = PageRequest.of(0, 10, sort);
			return pageable;
		};
		List<User> result = userService.findUserByPageable(supplier.get());
		System.out.println("----------" + result.size());
	}
	
	@Test
	@Rollback(value = true)
	@Transactional(transactionManager = "transactionManager")
	public void addAddress() {
		Supplier<User> supplier = () -> {
			User user = new User();
			user.setNickName("nickName");
			user.setRegisterDate(new Date());
			user.setUserName("userName");
			user.setUserPassword("password");
			user.setUserSex(new Short((short) 1));
			return user;
		};
		boolean success = userService.addUserService(supplier.get());
		Assert.isTrue(success, "failures");
	}
	
}

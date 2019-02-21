package com.duqio.boot.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duqio.boot.core.result.GeneralResult;
import com.duqio.boot.test.entity.User;
import com.duqio.boot.test.service.UserService;

@RestController
@RequestMapping("/userRestful")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/addUser")
	public GeneralResult addUser(User user){
		GeneralResult result = new GeneralResult();
		userService.addUserService(user);
		return result;
	}
	
	@GetMapping("/modUser")
	public GeneralResult modUser(User user){
		GeneralResult result = new GeneralResult();
		userService.modUserService(user);
		return result;
	}
	
	@GetMapping("/findUserByPage")
	public GeneralResult findUserByPage(int page){
		GeneralResult result = new GeneralResult();
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = PageRequest.of(page, 10, sort);
		List<User> users = userService.findUserByPageable(pageable);
		result.setResult(users);
		return result;
	}
	
	@GetMapping("/findUserById")
	public GeneralResult findUserById(User user){
		GeneralResult result = new GeneralResult();
		User entity = userService.findUserByUserId(user);
		result.setResult(entity);
		return result;
	}
	
}

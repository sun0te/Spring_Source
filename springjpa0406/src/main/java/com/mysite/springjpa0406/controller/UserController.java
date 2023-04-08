package com.mysite.springjpa0406.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.springjpa0406.entity.User;
import com.mysite.springjpa0406.repository.UserInfoMapping;
import com.mysite.springjpa0406.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserServiceImpl userServiceImpl;
	
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	
	@RequestMapping("/insertUser")
	public User insertUser(User user) {
		return userServiceImpl.insertUser(user);
	}
	
	@RequestMapping("/insertUser2")
	public void insertUser2(String id, String addr, int birth, int height, String mobile, String name) {
		userServiceImpl.insertUser2(id, addr, birth, height, mobile, name);
	}
	
	@RequestMapping("/listUser")	//객체 전체 반환
	public List<User> listUser() {
		return (List<User>)userServiceImpl.listUser();
	}
	
	@RequestMapping("/getUser")
	public User getUser(String id) {
		return userServiceImpl.getUser(id);
	}
	
	@RequestMapping("/getUserAddr")
	public List<User> getUserAddr(String addr) {
		return userServiceImpl.getUserAddr(addr);
	}
	
	@RequestMapping("/getUserAddr2")
	public List<User> getUserAddr2(String addr) {
		return userServiceImpl.getUserAddr2(addr);
	}
	
	@RequestMapping("/getUserAddrAndName")
	public List<User> getUserAddrAndName(String addr, String name) {
		return userServiceImpl.getUserAddrAndName(addr, name);
	}
	
	@RequestMapping("/updateUser")
	public void updateUser(String id, String addr, String mobile) {
		userServiceImpl.updateUser(id, addr, mobile);
	}
	
	@RequestMapping("/deleteUser")
	public void deleteUser(String id) {
		userServiceImpl.deleteUser(id);
	}
	
	@RequestMapping("/listUserOrderId")
	public List<User> listUserOrderId() {
		return userServiceImpl.listUserOrderId();
	}
	
	@RequestMapping("/listUserOrderNameDesc")
	public List<User> findAllByOrderByNameDesc() {
		return (List<User>)userServiceImpl.findAllByOrderByNameDesc();
	}
	
	@RequestMapping("/listUserAddr")
	public List<UserInfoMapping> listUserAddr(String addr) {
		return (List<UserInfoMapping>)userServiceImpl.listUserAddr(addr);
	}
	
	
	
}

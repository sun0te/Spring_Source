package com.mysite.springjpa0406.service;

import java.util.List;

import com.mysite.springjpa0406.entity.User;
import com.mysite.springjpa0406.repository.UserInfoMapping;

public interface UserService {

	public User insertUser(User user);
	public void insertUser2(String id, String addr, int birth, int height, String mobile, String name);
	public List<User> listUser();
	public User getUser(String id);
	public List<User> getUserAddr(String addr);	//추가
	public List<User> getUserAddr2(String addr);	//추가
	public List<User> getUserAddrAndName(String addr, String name);	//추가
	public void updateUser(String id, String addr, String mobile);
	public void deleteUser(String id);
	public List<User> listUserOrderId();
	public List<User> listUserOrderName();
	public List<User> findAllByOrderByNameDesc();	//추가
	public List<UserInfoMapping> listUserAddr(String addr);	
	
}

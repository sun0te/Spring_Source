package com.mysite.springjpa0406.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.springjpa0406.entity.User;
import com.mysite.springjpa0406.repository.UserInfoMapping;
import com.mysite.springjpa0406.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public User insertUser(User user) {
		return repository.save(user);	//기본키가 동일한 데이터를 저장하면 수정되는 방식으로 동작
	}

	@Override
	public void insertUser2(String id, String addr, int birth, int height, String mobile, String name) {
		repository.insertUser2(id, addr, birth, height, mobile, name);

	}

	@Override
	public List<User> listUser() {
		return (List<User>)repository.findAll();
	}

	@Override
	public User getUser(String id) {
		return repository.findById(id).orElse(null);	//값이 있을때는 해당 객체를 리턴하고 없으면 null을 반환
	}
	
	@Override
	public List<User> getUserAddr(String addr) {
		return repository.getUserAddr(addr);
	}
	
	@Override
	public List<User> getUserAddr2(String addr) {
		return repository.findByAddr(addr);
	}
	
	@Override
	public List<User> getUserAddrAndName(String addr, String name) {
		return repository.findByAddrAndName(addr, name);
	}
	

	@Override
	public void updateUser(String id, String addr, String mobile) {
		repository.updateUser(id, addr, mobile);
	}

	@Override
	public void deleteUser(String id) {
		repository.deleteById(id);

	}

	@Override
	public List<User> listUserOrderId() {
		return repository.findAllByOrderByIdAsc();
	}

	@Override
	public List<User> listUserOrderName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> findAllByOrderByNameDesc() {
		return (List<User>)repository.findAllByOrderByNameDesc();
	}


	@Override
	public List<UserInfoMapping> listUserAddr(String addr) {
		return (List<UserInfoMapping>)repository.findAllByAddr(addr);
	}



}

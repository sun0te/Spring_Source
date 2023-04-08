package com.mysite.springjpa0406.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mysite.springjpa0406.entity.User;

import jakarta.transaction.Transactional;

// 자동으로 빈으로 등록됨 
// JpaRepository<User, String> : JPA 가 관리하는 Repo는 User 테이블이고 키본키는 String 이라는 의미
// @Repository : 셍략 가능, 스프링부트에서는 생략되어도 동일하게 적용된다
public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Transactional // 트랜젝션 단위로 실행하도록 한다.
	@Query(value="insert into user(userid, addr, birth, height, mobile, name) values(:id, :addr, :birth, :height, :mobile, :name)", nativeQuery=true)
	void insertUser2(String id, String addr, int birth, int height, String mobile, String name);
	
	@Query(value="select * from user where addr = :addr", nativeQuery=true)
	List<User> getUserAddr(String addr);
	
	List<User> findByAddr(String addr);	//네이밍 규직으로 생성, 쿼리문 필요없음(자동으로 만들어짐)
	
//	@Query(value="select * from user where addr = :addr and name = :name", nativeQuery=true)
	List<User> findByAddrAndName(String addr, String name);

	@Modifying
	@Transactional
	@Query(value="update user set addr = :addr, mobile = :mobile where userid = :id", nativeQuery=true)
	public void updateUser(String id, String addr, String mobile);

	List<User> findAllByOrderByIdAsc();
	
	List<User> findAllByOrderByNameDesc();
	
	// UserInfoMapping : 추출하고자 하는 컬럼값을 읽는 인터페이스
	List<UserInfoMapping> findAllByAddr(String addr); 
}

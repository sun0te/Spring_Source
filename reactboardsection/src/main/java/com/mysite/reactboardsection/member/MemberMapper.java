package com.mysite.reactboardsection.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
	
	@Select("select count(*) as 'cnt' from member where id=#{id} and pw=#{pw}")
	public int login(MemberVO member);	//로그인 체크
	
	@Insert("insert into member values (#{id}, #{pw}, #{email})")
	public int insertMember(MemberVO member);	//회원가입 기능
	
}

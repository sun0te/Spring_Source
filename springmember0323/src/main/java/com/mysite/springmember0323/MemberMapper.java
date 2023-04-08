package com.mysite.springmember0323;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
	
	@Insert("INSERT INTO smember Values (#{id}, #{password}, #{name}, #{age}, #{gender}, #{email})")
	public int insertMember(MemberVO memberVO);
	
	@Select("SELECT count(*) From smember Where id = #{id} and password = #{password}")
	public int userCheck(MemberVO memberVO);
	
	@Select("SELECT * From smember order by id")
	ArrayList<MemberVO> getMemberlist();
	
	@Select("SELECT * From smember where id=#{id}")
	public MemberVO selectMember(MemberVO memberVO);
	
	@Update("UPDATE smember Set password=#{password}, name=#{name}, age=#{age}, gender=#{gender}, email=#{email} where id=#{id}")
	public int updateMember(MemberVO memberVO);
	
	@Delete("DELETE from smember Where id=#{id} ")
	public int deleteMember(MemberVO memberVO);
	
	
}

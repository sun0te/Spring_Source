package com.mysite.springmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
	
	@Select("select * from tab_mybatis order by name")
	ArrayList<MemberVO> getMembers();

	@Select ("select * from tab_mybatis where id=#{id, javaType=String}")
	MemberVO getMember(String id);
	
	@Insert("insert into tab_mybatis values (#{id, javaType=String},#{name, jdbcType=VARCHAR}, #{email}, #{phone})")
	void insertMember(MemberVO member); 

	@Update("update tab_mybatis set name=#{name}, email=#{email}, phone=#{phone} WHERE id=#{id}")
	void updateMember(MemberVO member);
	
	@Delete("delete from tab_mybatis where id=#{id}")
	void deleteMember(String id);

}

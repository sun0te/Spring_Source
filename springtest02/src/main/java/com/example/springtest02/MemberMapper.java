package com.example.springtest02;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper  //interface를 매퍼로 등록하기 위해 사용(sql 문을 호출하기 위해 사용 : 즉 특정 메서드와 특정 sql 구문을 매핑)
public interface MemberMapper {
	
	@Select("select * from member order by id")
	ArrayList<MemberVO> getMembers(); //getMembers() 이름의 메서드로 sql문을 호출하고 싶다
	
	@Insert("insert into member values(#{id}, #{pw}, #{email})")
	int insertMember(MemberVO member); //회원 정보 저장, 의존성 주입이 될 맴버 객체 전달받음

//	@Insert("insert into member values(#{id}, #{pw}, #{email})")
//	int insertMember(@Param("member") MemberVO member); //회원 정보 저장, 의존성 주입이 될 맴버 객체 전달받음

	@Select("select * from member where id=#{id}")
	public MemberVO selectMember(@Param("id") String id); //파라미터러로 전달받은 id값을 String id로 사용
	
//	@Update("update member set pw=#{pw}, email=#{email} where id = #{id}")
//	public int updateMember(@Param("id") String id, @Param("pw") String pw, @Param("email") String email);
	
	@Update("update member set pw=#{pw}, email=#{email} where id = #{id}")
	public int updateMember(MemberVO member); //이것도 가능

	@Delete("delete from member where id = #{id}")
	public int deleteMember(@Param("id") String id); 

	@Select("select count(*) from member")
	public int countMember();

	
}


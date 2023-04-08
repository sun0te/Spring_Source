package com.mysite.springtest0322;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper  //interface를 매퍼로 등록하기 위해 사용(sql 문을 호출하기 위해 사용 : 즉 특정 메서드와 특정 sql 구문을 매핑)
public interface MemberMapper {
	
	ArrayList<MemberVO> getMembers(); //getMembers() 이름의 메서드로 sql문을 호출하고 싶다
	
	int insertMember(MemberVO member); //회원 정보 저장, 의존성 주입이 될 맴버 객체 전달받음

	public MemberVO selectMember(@Param("id") String id); //파라미터러로 전달받은 id값을 String id로 사용
	
	//HashMap 설정 추가
	public HashMap<String, String> selectMember2(@Param("id") String id);
	public HashMap<String, String> selectMember3(@Param("id") String id);
	public LoginVO selectMember4(@Param("id") String id);
	
	public int updateMember(MemberVO member); //이것도 가능

	public int deleteMember(@Param("id") String id); 

	public int countMember();

	
}


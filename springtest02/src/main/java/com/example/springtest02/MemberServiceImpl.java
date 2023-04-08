package com.example.springtest02;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	MemberMapper mapper; //필드 정의
	
	public MemberServiceImpl (MemberMapper mapper) {  // 생성자 //생성자(권장방법, ㅡMemberMapper mapper 파라메터로 mapper 값을 전달받음- 의존정 주입이 발생)
		this.mapper = mapper;
	}
	
//	@Autowired(required=false) // 필드 required=true가 기본값
//	MemberMapper mapper;
	
//	@Autowired  // setter를 이용한 방식
//	public void setMapper(MemberMapper mapper) {
//		this.mapper = mapper;
//	}

	@Override
	public ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> memberlist = mapper.getMembers(); //mysql에 있는 memberlist 반환, memberlist 에 sql 결과물 저장됨
		return memberlist;
	}

	@Override
	public int insertMember(MemberVO member) {
		int res = mapper.insertMember(member);
		return res;
	}
	
	@Override
	public MemberVO selectMember(String id) {
		MemberVO vo = mapper.selectMember(id); //vo에 MemberVO의 객체가 저장
		return vo;
	}

//	@Override
//	public int updateMember(String id, String pw, String email) {
//		int res = mapper.updateMember(id,  pw,  email);
//		return res;
//	}
	
	@Override
	public int updateMember(MemberVO member) {
		int res = mapper.updateMember(member);
		return res;
	}
	
	@Override
	public int deleteMember(String id) {
		int res = mapper.deleteMember(id);
		return res;
	}
	
	@Override
	public int countMember() {
		int res = mapper.countMember();
		return res;
	}
}


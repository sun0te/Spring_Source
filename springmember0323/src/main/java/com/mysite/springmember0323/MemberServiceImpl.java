package com.mysite.springmember0323;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service("memberService") 
//원래 클래스이름 첫 글자가 소문자인 bean 객체가 만들어진다. 
//이름을 지정하면 지정한 이름의 bean 객체로 만들어진다.
public class MemberServiceImpl implements MemberService {

	MemberMapper mapper;
	
	public MemberServiceImpl (MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public int insertMember(MemberVO memberVO) {
		int res = mapper.insertMember(memberVO);
		return res;
	}
	
	@Override
	public int userCheck(MemberVO memberVO) {
		int res = mapper.userCheck(memberVO);
		return res;
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> list = mapper.getMemberlist();
		return list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO list = mapper.selectMember(memberVO);
		return list;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		int res = mapper.updateMember(memberVO);
		return res;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		int res = mapper.deleteMember(memberVO);
		return res;
	}
	
}

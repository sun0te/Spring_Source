package com.mysite.springmybatis;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	public MemberServiceImpl(MemberMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList = mapper.getMembers();
		
		return memberList;
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		member = mapper.getMember(id);
 		
		return member;
	}

	@Override
	public void insertMember(MemberVO member) {
		mapper.insertMember(member); 
	}

	@Override
	public void updateMember(MemberVO member) {
		mapper.updateMember(member);
	}

	@Override
	public void deleteMember(String id) {
		mapper.deleteMember(id);
	}

}

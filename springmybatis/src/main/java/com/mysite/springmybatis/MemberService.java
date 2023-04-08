package com.mysite.springmybatis;

import java.util.ArrayList;

public interface MemberService {
	public ArrayList<MemberVO> getMembers();
	public MemberVO getMember(String id);
	public void insertMember(MemberVO member);
	public void updateMember(MemberVO member);
	public void deleteMember(String id);
}

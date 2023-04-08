package com.mysite.springtest0322;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberService {
	ArrayList<MemberVO> getMembers();
	int insertMember(MemberVO member);
	public MemberVO selectMember(String id);
	
	public HashMap<String, String> selectMember2(String id);
	public HashMap<String, String> selectMember3(String id);
	public LoginVO selectMember4(String id);
	
	public int updateMember(MemberVO member);
	public int deleteMember(String id);
	public int countMember();
}

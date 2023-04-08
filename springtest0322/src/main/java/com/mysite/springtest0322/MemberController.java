package com.mysite.springtest0322;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	
	MemberServiceImpl memberServiceImpl;
	
	public MemberController (MemberServiceImpl memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	
	@GetMapping("/getMembers")  //(MemberVO에서 선언) 여러 개의 리스트를 반환하기 때문에 s가 붙는다
	//@RequestMapping(value="/getMembers", method=RequestMethod.GET)
	ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> memberlist = memberServiceImpl.getMembers();
		
		return memberlist;
	}
	
	@PostMapping("/insertMember")
	public int insertMember(MemberVO member) { //insert 작업 호출을 위한 작업
		MemberVO vo = MemberVO.builder()
								.id("qqq")
								.pw("1234")
								.email("qqq@qwer.com")
								.build();
		//new MemberVO("qqq", "3333"); //일부만 가지고 객체를 만들고 싶을 때 builder() 사용
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getEmail());
		System.out.println(vo);
		int res = memberServiceImpl.insertMember(member);
		
		return res;
	}
	
	@GetMapping("/selectMember")
	//public MemberVO selectMember(String id) {
	//public MemberVO selectMember(@RequestParam(value="id")String id) { //파라미터가 여러 개일 때 정확하게 이름을 지정해서 받는다
	public MemberVO selectMember(@RequestParam String id) { //파라미터의 이름과 변수의 이름 id가 동일하면 value를 생략할 수 있다
		MemberVO vo = memberServiceImpl.selectMember(id);
		return vo;
	}
	
	@GetMapping("/selectMember2")
	public HashMap<String, String> selectMember2(String id) {
		HashMap<String, String> vo = memberServiceImpl.selectMember2(id);
		return vo;
	}
	
	@GetMapping("/selectMember3")
	public HashMap<String, String> selectMember3(String id) {
		HashMap<String, String> vo = memberServiceImpl.selectMember3(id);
		return vo;
	}
	
	@GetMapping("/selectMember4")
	public LoginVO selectMember4(String id) {
		LoginVO vo = memberServiceImpl.selectMember4(id);
		return vo;
	}

	@PostMapping("/updateMember")
	public int updateMember(MemberVO member) {
		int res = memberServiceImpl.updateMember(member);
		return res;
	}
	
	@PostMapping("/deleteMember")
	public int deleteMember(String id) {
		int res = memberServiceImpl.deleteMember(id);
		return res;
	}
	
	@GetMapping("/countMember")
	public int countMember() {
		int res = memberServiceImpl.countMember();
		return res;
	}
	
}
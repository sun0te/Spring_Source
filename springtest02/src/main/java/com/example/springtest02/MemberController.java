package com.example.springtest02;

import java.util.ArrayList;

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
	
	@GetMapping("/getMembers")  //(MemberVO에서 선언) 
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
	
//	@PostMapping("/updateMember")
//	public int updateMember(@RequestParam String id, @RequestParam String pw, @RequestParam String email) {
//		int res = memberServiceImpl.updateMember(id,  pw,  email);
//		return res;
//	}

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
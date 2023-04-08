package com.mysite.reactboardsection.member;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//리액트와 연결하기 때문에 데이처를 반환해주는 RestController로 사용
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/login")	//@RequestBody : Json 기반의 메시지를 사용하는 요청의 경우 사용
	public int login(@RequestBody MemberVO vo) throws Exception {
		int res = memberService.login(vo);
//		System.out.println("res : "+res);
		
		return res;
	}
	
	@RequestMapping("/insertMember")
	public int insertMember(@RequestBody MemberVO vo) throws Exception {
		int res = memberService.insertMember(vo);
		
		return res;
	}
	
}

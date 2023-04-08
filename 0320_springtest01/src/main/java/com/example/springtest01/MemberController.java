package com.example.springtest01;

import java.lang.reflect.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller  //MemberController 라는 빈 객체가 자동으로 생성된다.
public class MemberController {
	
	@GetMapping("/getMember")
	public Member getMember(Member member) {
		member.setNum(1);
		member.setIrum("Lee");
		member.setAge(27);
		
		return member;
	}
	
	@PostMapping("/postMember1")
	public Member postMember(Member member) {
		return member;
	}
	
}
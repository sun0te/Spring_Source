package com.example.springtest01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller //MemberController 라는 빈 객체가 자동으로 생성된다.
@RestController
public class MemberController {
//	@GetMapping("/getMember")
	@RequestMapping(value="/getMember", method=RequestMethod.GET)
	public MemberVO getMember(MemberVO member) {  // member 객체는 의존성 주입(DI)으로 전달됨
//		member.setNum(1);
//		member.setIrum("Lee");
//		member.setAge(27);
		
		return member;
	}
	
//	@PostMapping("/postMember1")
	@RequestMapping(value="/postMember1", method = RequestMethod.POST)
	public MemberVO postMember1(MemberVO member) { //member 객체는 의존성 주입으로 전달됨
		
		System.out.println("member.getNum() : " + member.getNum());
		System.out.println("member.getNum() : " + member.getIrum());
		System.out.println("member.getNum() : " + member.getAge());
		
		return member;
	}
}

package com.mysite.springmybatis;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
		
	private MemberService memberServiceImpl;
	
	public MemberController (MemberService memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	
	@RequestMapping("/") //시작 메인화면
	public String strat() {
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public ModelAndView main(Locale locale, ModelAndView result) {
		List<MemberVO> memberList = memberServiceImpl.getMembers();
		
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(MemberVO member, ModelAndView result){
		memberServiceImpl.insertMember(member);

		List<MemberVO> memberList = memberServiceImpl.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(MemberVO member, ModelAndView result){
		member = memberServiceImpl.getMember(member.getId());

		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(MemberVO member, ModelAndView result){
		memberServiceImpl.updateMember(member);

		List<MemberVO> memberList = memberServiceImpl.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") String id, ModelAndView result){
		memberServiceImpl.deleteMember(id);

		List<MemberVO> memberList = memberServiceImpl.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
}

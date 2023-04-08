package com.mysite.springmember0323;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller //기본적으로 뷰(view)를 반환한다.
public class MemberController {
	
	// MemberService 로 의존성 주입해도 문제없다(자식 객체 타입을 부모 타입에 대입하기 때문)
	MemberService memberService; 
	//MemberServiceImpl memberServiceImpl; 
	
	
	//이미 만들어진 해당 bean 객체를 memberService 에 주입한다. (의존성 주입)
	public MemberController (MemberService memberService) {
			this.memberService = memberService;
	}
//	public MemberController (MemberServiceImpl memberServiceImpl) { 
//		this.memberServiceImpl = memberServiceImpl; 
//	}
	
	
	@RequestMapping("/") //method를 생략하면 get, set 방식 모두 처리가 가능하다
	public String startPage() {
		return "loginForm";
	}
	
	@RequestMapping("/loginform.me") 
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/joinform.me")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.me")
	public void insertMember(MemberVO memberVO, HttpServletResponse response) throws Exception {
		int res = memberService.insertMember(memberVO); //insert 실행
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(res != 0)
		{
			writer.write("<script>alert('회원가입 성공!');"
					+ "location.href = './loginform.me';</script>");
		}
		else 
		{
			writer.write("<script>alert('회원가입 실패!');"
					+ "location.href = './joinform.me';</script>");
		}
	}
	
	@RequestMapping("/login.me")
	public String userCheck(MemberVO memberVO, HttpSession session, HttpServletResponse response) throws Exception {
		//찾는 id, password 가 들어간 memberVO 객체를 전달받아 주입시킴
		int res = memberService.userCheck(memberVO); 
		//전달받은 id, password를 userCheck
		
		//count 함수 사용으로 존재하면 1, 없으면 0 반환된다.
		System.out.println("res : "+ res);
		
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter writer = response.getWriter();
		
		if(res == 1)
		{
			session.setAttribute("id", memberVO.getId());
			System.out.println("session.getAttrubute(id)" + session.getAttribute("id"));
//			writer.write("<script> alert('로그인 성공!'); location.href = './main.me'; </script>");
			return "redirect:/main.me";
		}
		else 
		{
//			writer.write("<script> alert('로그인 실패!'); location.href = './loginform.me'; </script>");
			return "redirect:/loginform.me";
		}

	}
	
	@RequestMapping("/main.me")
	public String mainPage() {
		return "main";
	}
	
	//Model : 뷰에게 전달할 데이터를 저장, 뷰에서는 request.getAttribute 로 데이터를 가져옴
	//ModelAndView : 뷰와 데이터를 저장해서 전달
//	@RequestMapping("/memberlist.me")
//	public String getmemberlist(Model model) {	
//		ArrayList<MemberVO> member_list = memberService.getMemberlist();
//		model.addAttribute("member_list", member_list);
//		
//		return "member_list";
//	}
	
	@RequestMapping("/memberlist.me")
	public ModelAndView getmemberlist(ModelAndView mv) {	
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		mv.addObject("member_list", member_list);
		mv.setViewName("member_list");
		
		return mv;
	}
	
	@RequestMapping("/memberinfo.me")
	public String selectMember(MemberVO memberVO, Model model) {
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_info";
	}
	
	@RequestMapping("/updateform.me")
	public String updateForm(MemberVO memberVO, Model model) { 
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_updateForm";
	}
	
	@RequestMapping("/update.me")
	public String update(MemberVO memberVO) {
		memberService.updateMember(memberVO);
		return "redirect:/memberlist.me";
	}
	
	@RequestMapping("/memberdelete.me")
	public String deleteMember(MemberVO memberVO) {
		memberService.deleteMember(memberVO);
		return "redirect:/memberlist.me";
	}
	
}

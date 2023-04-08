package com.mysite.springimage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {
	
	@RequestMapping("/")
	public String main() {
		return "test";  //test.jsp
	}
}

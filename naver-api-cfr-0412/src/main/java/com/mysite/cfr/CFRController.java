package com.mysite.cfr;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CFRController {

	@Value("${spring.servlet.multipart.location}")
	String uploadDir;
	
	@RequestMapping("/upload")
	@ResponseBody	
	public String main(MultipartFile uploadfile, CFRApi face) throws IOException {
		File storedFilename = new File(UUID.randomUUID().toString() + "_" + uploadfile.getOriginalFilename());
		uploadfile.transferTo(storedFilename);
		String imgFile = uploadDir + "\\" + storedFilename.toString();
		String result = face.psocCFR(imgFile);
		return result;
	}
	
	
}

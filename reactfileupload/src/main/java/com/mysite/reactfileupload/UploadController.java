package com.mysite.reactfileupload;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

@Controller
public class UploadController {
	
	//application.yml(설정파일)에 설정된 내용을 주입시켜주는 어노테이션
	@Value("${spring.servlet.multipart.location}")
	String uploadDir;
	
	@ResponseBody	//리액트에서 데이터를 JSON 형식으로 전달받기 위해 사용
	@RequestMapping("/upload")
	public List<FileVO> upload(@RequestParam MultipartFile[] uploadfiles) throws IOException {
		List<FileVO> list = new ArrayList<>(); 
		for(MultipartFile file : uploadfiles) {
			if(!file.isEmpty()) {
				File storedFilename = new File(UUID.randomUUID().toString() + "_" + file.getOriginalFilename());
				FileVO entity = new FileVO(file.getOriginalFilename(), 
											storedFilename.toString(), 
											file.getContentType());
				
				list.add(entity);
				file.transferTo(storedFilename);	//transferTo를 통해 업로드
			}
		}//for
		
		return list;	//리스트 파일 객체 반환
	}
	
	@RequestMapping("/download")
	public ResponseEntity<UrlResource> download(@RequestParam("originfilename") String originfilename,
			@RequestParam("storedfilename") String storedfilename) throws MalformedURLException {
		
		//	c:\\project\\upload\\파일이름
		UrlResource resource = new UrlResource("file:" + uploadDir + "/" + storedfilename);
		String encodedFileName = UriUtils.encode(originfilename, StandardCharsets.UTF_8);
		
		// encodedFileName: 실제 저장될 때 사용할 파일명 -> contentDisposition에 저장
		String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";
		
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
	
}

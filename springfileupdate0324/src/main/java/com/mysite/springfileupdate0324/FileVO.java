package com.mysite.springfileupdate0324;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileVO {
	private String originfilename;	//첨부할 때 사용된 원파일명
	private String storedfilename;	//서버에 저장될 때 사용할 파일명
	private String contenttype;		//파일 타입
}

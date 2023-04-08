package com.mysite.springmember0323;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String email;
}

package com.example.springtest02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data // get/set 메서드, default 생성자, 모든 아규먼트 생성자 등을 자동으로 생성함
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor	//final필드, @NonNull 인 필드값만 차라메터를 받는 생성자 구현
@ToString
@EqualsAndHashCode
@Builder
public class MemberVO {
	private String id;
	private String pw;
	private String email;
}


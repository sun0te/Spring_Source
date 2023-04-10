package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@Column(columnDefinition = "TEXT")	//columnDefinition: 컬럼의 속성을 정의할 때 사용, "TEXT" : 글자 수를 제한할 수 없을 때 사용
	private String content;
	
	private LocalDateTime createDate;
	
	@ManyToOne
	private Question question;
}

package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")	//columnDefinition: 컬럼의 속성을 정의할 때 사용, "TEXT" : 글자 수를 제한할 수 없을 때 사용
	private String content;
	
	private LocalDateTime createDate;
	
	//mappedBy = "question" Answer 엔티티에 있는 question을 의미
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)	//CascadeType.REMOVE : 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제
	private List<Answer> answerList;
	
}

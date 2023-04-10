package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

// jUnit : 테스트 코드를 작성하고 작성한 테스트 코드를 실항하기 위한 테스트 프레임워크
@SpringBootTest
class SpringBootBoard0410ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;	//의존성 주입
	
	@Autowired
	private AnswerRepository anserRepository;
	
	@Test
	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("ssb가 무엇인가요?");
//		q1.setContent("ssb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);	//첫 번째 질문 저장
		
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);	//두 번째 질문 저장
		
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());	//assertEquals(기대값, 실제값): 기대값과 실제값이 동일한지를 검사
		
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네, 자동으로 생성됩니다.");
		a.setQuestion(q);	// 어떤 질문의 답변인지 알기 위해서 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.anserRepository.save(a);

	}

}

package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    
    public Question getQuestion(Integer id) {  
    	// Optional : null이 올 수 있는 값을 감싸는 Wrapper클래스. 참조하더라도 NPE(Null Point Exception)이 발생하지 않도록 한다.
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) { // isPresent() : question이 null 이 아닌지 검사
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

}

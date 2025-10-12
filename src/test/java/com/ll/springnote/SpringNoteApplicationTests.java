package com.ll.springnote;

import com.ll.springnote.domain.question.Question;
import com.ll.springnote.domain.question.QuestionRepository;
import com.ll.springnote.domain.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringNoteApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionService questionService;

	@Test
	void jpaTest() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void testJpafindById() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	@Test
	void testJpafindBysubject(){
		Question q = questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId() );
	}

	@Test
	void testJpafindBysubjectAndContent(){
		Question q = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId() );
	}

	@Test
	void testJpaDeleteQuestion(){
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	@Test
	void testPageing(){
		for (int i = 0; i <= 300; i++){
			String subject = String.format("테스트 데이터: [%03d]", i);
			String content = "내용 없음";
			this.questionService.create(subject, content);
		}
	}












@Test
	void check(){
		assertEquals(2, this.questionRepository.count());
}


}

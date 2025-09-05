package com.ll.springnote.domain.Answer;

import com.ll.springnote.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Question, Integer> {
}

package com.ll.springnote.domain.Answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "내용을 적어주세요")
    @Size(max = 300)
    private String content;
}

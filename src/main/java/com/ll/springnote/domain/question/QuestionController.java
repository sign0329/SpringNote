package com.ll.springnote.domain.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {

        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question/list";

    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question/detail";
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
        this.questionService.create(subject, content);
        return "redirect:/question/list";
    }
}

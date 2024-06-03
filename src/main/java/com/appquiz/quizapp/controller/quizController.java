package com.appquiz.quizapp.controller;


import com.appquiz.quizapp.model.Question;
import com.appquiz.quizapp.model.Responses;
import com.appquiz.quizapp.model.questionWrapper;
import com.appquiz.quizapp.service.QuizService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    QuizService quizservice;


    @PostMapping("create")
    //basically request param used to accept url parameters
    public ResponseEntity<String> createQuiz(@RequestParam String technology, @RequestParam int numQues, @RequestParam String title) {

        return quizservice.createQuiz(technology, numQues, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<questionWrapper>> getQuizQuestions(@PathVariable Integer id) {

        return quizservice.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Responses> responses){

        return quizservice.calculateResult(id,responses);

    }
}



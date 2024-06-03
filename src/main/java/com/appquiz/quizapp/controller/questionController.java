package com.appquiz.quizapp.controller;


import com.appquiz.quizapp.model.Question;
import com.appquiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")

public class questionController {


    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        //basically response entity us used to return the status code and above is the method to implement and service class has return method

        return questionService.getAllQuestions();
    }

    @GetMapping("technology/{technology}")
    public ResponseEntity<List<Question>>getCategory(@PathVariable String technology){


        return questionService.getCategory(technology);
    }

    @PostMapping("addQuestion")
    public ResponseEntity <String> addQuestions(@RequestBody Question question){

         return questionService.addQuestions(question);
    }

    @DeleteMapping("delQuestion/{id}")
    public ResponseEntity<String> deleteQues(@PathVariable Integer id){

        return questionService.deleteQues(id);
    }


}

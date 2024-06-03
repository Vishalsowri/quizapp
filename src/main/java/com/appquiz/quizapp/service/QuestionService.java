package com.appquiz.quizapp.service;


import com.appquiz.quizapp.model.Question;
import com.appquiz.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {

        //since to handle exception we use try catch
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //incase no data we have return empty array like below

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Question>> getCategory(String technology) {

        try {
            return new ResponseEntity<>(questionDao.findByTechnology(technology), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }


    public ResponseEntity<String> addQuestions(Question question) {

        try {
            questionDao.save(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQues(Integer id) {

        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);

    }
}

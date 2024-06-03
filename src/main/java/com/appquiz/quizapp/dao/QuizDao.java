package com.appquiz.quizapp.dao;

import com.appquiz.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface QuizDao extends JpaRepository<Quiz, Integer> {


}

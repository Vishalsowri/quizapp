package com.appquiz.quizapp.dao;


import com.appquiz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>

    {


        //the below method we call jpa query language

        List<Question> findByTechnology(String technology);

        @Query(value = "SELECT * from question q WHERE q.technology=:technology ORDER BY RANDOM() LIMIT :numQues",nativeQuery = true)
        List<Question> findRandomTech(String technology,int numQues);
    }


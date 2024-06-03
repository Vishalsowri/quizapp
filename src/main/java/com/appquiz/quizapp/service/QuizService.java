package com.appquiz.quizapp.service;

import com.appquiz.quizapp.dao.QuestionDao;
import com.appquiz.quizapp.dao.QuizDao;
import com.appquiz.quizapp.model.Question;
import com.appquiz.quizapp.model.Quiz;
import com.appquiz.quizapp.model.Responses;
import com.appquiz.quizapp.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;




    public ResponseEntity<String> createQuiz(String technology, int numQues, String title) {

        List<Question> question = questionDao.findRandomTech(technology,numQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(question);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);




    }

    public ResponseEntity<List<questionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> quesDb = quiz.get().getQuestion();
        List<questionWrapper> quesUsr = new ArrayList<>();
        for(Question q: quesDb){
            questionWrapper qw = new questionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3());
            quesUsr.add(qw);

        }


        return new ResponseEntity<>(quesUsr,HttpStatus.OK);


    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Responses> response) {


        //we can use get() or optional if may null or  no value is availabel
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestion();
        int right = 0;
        int i = 0;


        for (Responses responses: response){
            if(responses.getResponses().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;

        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}

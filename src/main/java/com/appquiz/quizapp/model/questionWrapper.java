package com.appquiz.quizapp.model;


import lombok.Data;

@Data
public class questionWrapper {


    private Integer id;


    public questionWrapper(Integer id, String questionTitle, String option1, String option2, String option3) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
}

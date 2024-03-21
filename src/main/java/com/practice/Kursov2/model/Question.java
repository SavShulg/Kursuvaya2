package com.practice.Kursov2.model;

public class Question {

    private final String quastion;
    private final String answer;

    public Question(String quastion, String answer) {
        this.quastion = quastion;
        this.answer = answer;
    }

    public String getQuastion() {
        return quastion;
    }

    public String getAnswer() {
        return answer;
    }
}

package com.practice.Kursov2.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(quastion, question.quastion) && Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quastion, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "quastion='" + quastion + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

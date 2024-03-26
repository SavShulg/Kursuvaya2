package com.practice.Kursov2.service;

import com.practice.Kursov2.exeptions.NotEnoughQuestionException;
import com.practice.Kursov2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerServise{
    private final QuestionServise mathServise;
    private final QuestionServise javaServise;
    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("java") QuestionServise mathServise,
                               @Qualifier("math") QuestionServise javaServise) {
        this.mathServise = mathServise;
        this.javaServise = javaServise;
    }


    @Override
    public Collection<Question> getQuestion(int amount) {


        var allQuestions = new ArrayList<>(mathServise.getAll());
        allQuestions.addAll(javaServise.getAll());

        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionException();
        }
        if (amount == allQuestions.size()) {
            return allQuestions;
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            var question = random.nextBoolean() ? mathServise.getRandomQuestion() : javaServise.getRandomQuestion();
            questions.add(question);
        }

        return questions;
    }
}

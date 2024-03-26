package com.practice.Kursov2.service;

import com.practice.Kursov2.exeptions.NotFoundQuestionsException;
import com.practice.Kursov2.model.Question;
import com.practice.Kursov2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service("math")
public class MathQuestionServise implements QuestionServise{
    private final Random random = new Random();
    private final QuestionRepository repository;

    public MathQuestionServise(@Qualifier("mathRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var questions = repository.getAll();
        var index = random.nextInt(questions.size());
        var i = 0;
        for (Question question : questions) {
            if (index == i) {
                return question;
            }
            i++;
        }
        throw new NotFoundQuestionsException();

    }

}

package com.practice.Kursov2.repository;

import com.practice.Kursov2.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("mathRepository")
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> storage = new HashSet<>();
    @PostConstruct
    private void init() {
        storage.add(new Question("q_m1", "a_m1"));
        storage.add(new Question("q_m2", "a_m2"));
        storage.add(new Question("q_m3", "a_m3"));
    }


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        storage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (storage.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(storage);
    }

}

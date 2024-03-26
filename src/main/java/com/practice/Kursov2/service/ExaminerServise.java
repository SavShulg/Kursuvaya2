package com.practice.Kursov2.service;

import com.practice.Kursov2.model.Question;

import java.util.Collection;

public interface ExaminerServise {
    Collection<Question> getQuestion(int amount);
}

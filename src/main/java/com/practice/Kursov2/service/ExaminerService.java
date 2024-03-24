package com.practice.Kursov2.service;

import com.practice.Kursov2.model.Question;
import jdk.internal.org.objectweb.asm.tree.analysis.SourceValue;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

    SourceValue getAll();

    Question getRandomQuestion();
}


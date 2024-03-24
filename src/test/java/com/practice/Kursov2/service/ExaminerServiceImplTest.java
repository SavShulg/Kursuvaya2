package com.practice.Kursov2.service;

import com.practice.Kursov2.exeptions.NotEnoughQuestionException;
import com.practice.Kursov2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    static List<Question> JAVA_QUESTIONS = List.of(
            new Question("list", "array_list"),
            new Question("cycle", "for"));



    @Mock
    JavaQuestionService javaQuestionService;

    @Test
    void testRandomQuestions() {
        for (int i = 0; i < 100; i++) {
            assertTrue(JAVA_QUESTIONS.contains(JavaQuestionService.getRandomQuestion()));
        }


    }
}

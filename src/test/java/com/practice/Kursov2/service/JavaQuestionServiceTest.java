package com.practice.Kursov2.service;

import com.practice.Kursov2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    static List<Question> QUESTIONS = List.of(
            new Question("test1", "test11"),
            new Question("test2", "test22"),
            new Question("test3", "test33"),
            new Question("test4", "test44"));


    @Mock
    JavaQuestionService service;

    @Test
    void testRandomQuestion() {
        for (int i = 0; i < 100; i++) {
            assertTrue(QUESTIONS.contains(service.getRandomQuestion()));

        }
    }

}
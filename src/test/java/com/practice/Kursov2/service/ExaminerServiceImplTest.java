package com.practice.Kursov2.service;

import com.practice.Kursov2.exeptions.NotEnoughQuestionException;
import com.practice.Kursov2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    static List<Question> MATH_QUESTIONS = List.of(
            new Question("1+1", "2"),
            new Question("5-1", "4"));

    static List<Question> JAVA_QUESTIONS = List.of(
            new Question("list", "array_list"),
            new Question("cycle", "for"));


    @Mock
    JavaQuestionService javaQuestionService;

    @Mock
    MathQuestionServise mathQuestionServise;

    ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService,mathQuestionServise);
        when(javaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
        when(mathQuestionServise.getAll()).thenReturn(MATH_QUESTIONS);
    }

    @Test
    void testRandom() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(JAVA_QUESTIONS.get(0));

        when(javaQuestionService.getRandomQuestion())
                .thenReturn(MATH_QUESTIONS.get(0))
                .thenReturn(MATH_QUESTIONS.get(1));

        var actual = examinerService.getQuestion(3);
        assertThat(actual).containsExactlyInAnyOrder(
                JAVA_QUESTIONS.get(0),
                MATH_QUESTIONS.get(0),
                MATH_QUESTIONS.get(1));
    }

    @Test
    void name() {
        assertThrows(NotEnoughQuestionException.class, () -> examinerService.getQuestion(100000));
    }
}

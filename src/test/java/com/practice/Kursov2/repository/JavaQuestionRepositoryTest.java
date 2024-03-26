package com.practice.Kursov2.repository;

import com.practice.Kursov2.model.Question;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    JavaQuestionRepository repository = new JavaQuestionRepository();

    @Test
    void testAdd() {
        repository.add(new Question("test1", "test11"));
        repository.add("test2", "test22");

        assertThat(repository.getAll()).containsExactlyInAnyOrder(
                new Question("test1", "test11"),
                new Question("test2", "test22"));
    }

    @Test
    void testRemove() {
        repository.add(new Question("test1", "test11"));
        repository.add("test2", "test22");

        var removed = repository.remove(new Question("test2", "test22"));
        assertThat(removed).isEqualTo(new Question("test2", "test22"));

        var empty = repository.remove(new Question("111", "222"));
        assertThat(empty).isNull();

        assertThat(repository.getAll()).containsExactlyInAnyOrder(
                new Question("test1", "test11"));

    }
}
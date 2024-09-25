package ru.vaganov.naumen.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Task4ExecutorTest {
    private Task4 task4;

    @BeforeEach
    void init() {
        task4 = new Task4();
    }

    @Test
    @DisplayName("getAcceptHeaders: в ответе лежат отправленные заголовки")
    void getAcceptHeaders() {
        String[] result = task4.getAcceptHeaders();
        Assertions.assertArrayEquals(new String[]{"application/json", "text/html"}, result);
    }
}
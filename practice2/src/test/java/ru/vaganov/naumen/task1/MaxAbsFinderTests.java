package ru.vaganov.naumen.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaxAbsFinderTests {

    private MaxAbsFinder maxAbsFinder;

    @BeforeEach
    void init() {
        maxAbsFinder = new MaxAbsFinder();
    }

    @Test
    @DisplayName("Большее по модулю: массив положительных по возрастанию")
    void process_returnsMaxAbs_OnAscArray() {
        Integer[] data = new Integer[]{10, 20, 30, 40};

        Integer result = maxAbsFinder.process(data.length, data);
        Assertions.assertEquals(40, result);
    }

    @Test
    @DisplayName("Большее по модулю: массив положительных по убыванию")
    void process_returnsMaxAbs_OnDescArray() {
        Integer[] data = new Integer[]{100, 50, 10, 5};

        Integer result = maxAbsFinder.process(data.length, data);
        Assertions.assertEquals(100, result);
    }

    @Test
    @DisplayName("Большее по модулю: положительное число")
    void process_returnsMaxAbs_ofBiggestPositiveNumber() {
        Integer[] data = new Integer[]{-100, 0, 1000, 10};

        Integer result = maxAbsFinder.process(data.length, data);
        Assertions.assertEquals(1000, result);
    }

    @Test
    @DisplayName("Большее по модулю: отрицательное число")
    void process_returnsMaxAbs_ofBiggestNegativeNumber() {
        Integer[] data = new Integer[]{20, 0, -1000, 10};

        Integer result = maxAbsFinder.process(data.length, data);
        Assertions.assertEquals(-1000, result);
    }

    @Test
    @DisplayName("Большее по модулю: пустой массив")
    void process_returnsMaxAbs_returnsNullOnEmptyArray() {
        Integer[] data = new Integer[]{};

        Integer result = maxAbsFinder.process(data.length, data);
        Assertions.assertNull(result);
    }
}

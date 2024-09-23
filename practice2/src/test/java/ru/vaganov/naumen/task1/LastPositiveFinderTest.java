package ru.vaganov.naumen.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LastPositiveFinderTest {

    private LastPositiveFinder lastPositiveFinder;

    @BeforeEach
    void init() {
        lastPositiveFinder = new LastPositiveFinder();
    }

    @Test
    @DisplayName("Последний положительный элемент: массив положительных по возрастанию")
    void process_returnsLastPositive_OnAscArray() {
        Integer[] data = new Integer[]{10, 20, 30, 40};

        Integer result = lastPositiveFinder.process(data.length, data);
        Assertions.assertEquals(40, result);
    }

    @Test
    @DisplayName("Последний положительный элемент: массив положительных по убыванию")
    void process_returnsLastPositive_OnDescArray() {
        Integer[] data = new Integer[]{100, 50, 10, 5};

        Integer result = lastPositiveFinder.process(data.length, data);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Последний положительный элемент: по краям отрицательные")
    void process_returnsLastPositive_ofBiggestPositiveNumber() {
        Integer[] data = new Integer[]{-100, 0, 1000, -10};

        Integer result = lastPositiveFinder.process(data.length, data);
        Assertions.assertEquals(1000, result);
    }

    @Test
    @DisplayName("Последний положительный элемент: null - если нет полжоительных")
    void process_returnsLastPositive_ofBiggestNegativeNumber() {
        Integer[] data = new Integer[]{-20, 0, -1000, -10};

        Integer result = lastPositiveFinder.process(data.length, data);
        Assertions.assertNull( result);
    }

    @Test
    @DisplayName("Последний положительный элемент: пустой массив")
    void process_returnsLastPositive_returnsNullOnEmptyArray() {
        Integer[] data = new Integer[]{};

        Integer result = lastPositiveFinder.process(data.length, data);
        Assertions.assertNull(result);
    }

}
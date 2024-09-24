package ru.vaganov.naumen.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Task2Test {
    private Task2 task2;

    @BeforeEach
    void init() {
        task2 = new Task2();
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив положительных")
    void selectionSortSorted() {
        List<Double> data = Arrays.asList(1d,2d,3d,4d);

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{1d,2d,3d,4d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: массив положительных по убыванию")
    void selectionSortSortedDesc() {
        List<Double> data = Arrays.asList(4d,3d,2d,1d);

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{1d,2d,3d,4d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив отрицательных")
    void selectionSortNegativeSorted() {
        List<Double> data = Arrays.asList(-5.,-4.,-3.,-1., 0.);

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{-5.,-4.,-3.,-1., 0.}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив отрицательных")
    void selectionSortNegativeSortedDesc() {
        List<Double> data = Arrays.asList(0., -1., -2., -3.);

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{-3d,-2d,-1d, 0d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: нет сортировки")
    void selectionSortnotSotrded() {
        List<Double> data = Arrays.asList(0., -20., 1.2, 0., 120.05, -200., 14.1, 1.);

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{-200.,-20., 0., 0.,1., 1.2,14.1,120.05}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: пустой массив")
    void selectionSortreturnsLastPositive_ofBiggestNegativeNumber() {
        List<Double> data = Arrays.asList(new Double[]{});

        task2.selectionSort(data);
        Assertions.assertArrayEquals(new Double[]{}, data.toArray());
    }
}
package ru.vaganov.naumen.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SelectionSorterTest {
    private SelectionSorter selectionSorter;

    @BeforeEach
    void init() {
        selectionSorter = new SelectionSorter();
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив положительных")
    void sort_Sorted() {
        List<Double> data = Arrays.asList(1d,2d,3d,4d);

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{1d,2d,3d,4d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: массив положительных по убыванию")
    void sort_SortedDesc() {
        List<Double> data = Arrays.asList(4d,3d,2d,1d);

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{1d,2d,3d,4d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив отрицательных")
    void sort_NegativeSorted() {
        List<Double> data = Arrays.asList(-5.,-4.,-3.,-1., 0.);

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{-5.,-4.,-3.,-1., 0.}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: отсортированный массив отрицательных")
    void sort_NegativeSortedDesc() {
        List<Double> data = Arrays.asList(0., -1., -2., -3.);

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{-3d,-2d,-1d, 0d}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: нет сортировки")
    void sort_notSotrded() {
        List<Double> data = Arrays.asList(0., -20., 1.2, 0., 120.05, -200., 14.1, 1.);

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{-200.,-20., 0., 0.,1., 1.2,14.1,120.05}, data.toArray());
    }

    @Test
    @DisplayName("Сортировка выбором: пустой массив")
    void sort_returnsLastPositive_ofBiggestNegativeNumber() {
        List<Double> data = Arrays.asList(new Double[]{});

        selectionSorter.sort(data);
        Assertions.assertArrayEquals(new Double[]{}, data.toArray());
    }
}
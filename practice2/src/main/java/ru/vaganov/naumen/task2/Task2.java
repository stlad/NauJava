package ru.vaganov.naumen.task2;

import java.util.List;

/**
 * Заполните список (тип “ArrayList<Double>”) случайным числами и
 * отсортируйте его. Метод сортировки выбирается в соответствии с вашим
 * вариантом. Сортировку необходимо реализовать вручную (не использовать
 * встроенные возможности Java или сторонних библиотек).
 */
public interface Task2 {

    String getTask();

    List<Double> process(List<Double> initList);
}

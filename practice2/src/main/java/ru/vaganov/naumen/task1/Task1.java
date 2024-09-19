package ru.vaganov.naumen.task1;

public interface Task1 {
    /**
     * Заполните массив (тип элементов “int”) случайными числ и выполните задание в соответствии со своим вариантом.
     * @param n Количесвто элементов массива
     * @param array Массив
     * @return результат
     */
    Integer process(Integer n, Integer[] array);

    String getTask();
}

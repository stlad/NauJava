package ru.vaganov.naumen.task1;

public class MaxAbsFinder implements Task1 {
    /**
     * Вариант 1. Найти максимальное значение по модулю в массиве
     *
     * @param array массив
     * @return максимальное значение по модулю в массиве
     */
    @Override
    public Integer process(Integer n, Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        Integer max = array[0];
        for (Integer num : array) {
            if (Math.abs(num) >= Math.abs(max)) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public String getTask() {
        return "Найти максимальное значение по модулю в массиве";
    }
}

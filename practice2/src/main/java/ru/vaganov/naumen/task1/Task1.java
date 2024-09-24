package ru.vaganov.naumen.task1;

public class Task1{
    /**
     * Заполните массив (тип элементов “int”) случайными числами и
     * выполните задание в соответствии со своим вариантом.
     * Вариант 4. Найти последний положительный элемент в массиве.
     * @param array массив
     * @return последний положительынй элемент
     */
    public Integer findLastPositive(Integer n, Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        for (int i = array.length - 1; i >= 0; --i) {
            if(array[i] > 0){
                return array[i];
            }
        }
        return null;
    }

    public String getTask() {
        return "Найти последний положительный элемент в массиве";
    }
}

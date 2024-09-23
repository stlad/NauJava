package ru.vaganov.naumen.task1;

public class LastPositiveFinder implements Task1 {
    /**
     * Вариант 4. Найти последний положительный элемент в массиве.
     *
     * @param array массив
     * @return последний положительынй элемент
     */
    @Override
    public Integer process(Integer n, Integer[] array) {
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

    @Override
    public String getTask() {
        return "Найти последний положительный элемент в массиве";
    }
}

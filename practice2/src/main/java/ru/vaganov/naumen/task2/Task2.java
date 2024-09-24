package ru.vaganov.naumen.task2;

import java.util.List;

public class Task2 {
    /**
     * Заполните список (тип “ArrayList<Double>”) случайным числами и
     * отсортируйте его. Метод сортировки выбирается в соответствии с вашим
     * вариантом. Сортировку необходимо реализовать вручную (не использовать
     * встроенные возможности Java или сторонних библиотек).
     * Вариант 4. Сортировка выбором (SelectionSort)
     * Сортировка происходит в пеерданной коллекции. Без копирования.
     *
     * @param initList массив
     */
    public void selectionSort(List<Double> initList) {
        for (int i = 0; i < initList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < initList.size(); j++) {
                if (initList.get(j) < initList.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(i, minIndex, initList);
            }
        }
    }

    private void swap(int first, int second, List<Double> list) {
        Double buffer = list.get(first);
        list.set(first, list.get(second));
        list.set(second, buffer);
    }


    public String getTask() {
        return "Сортировка выбором (Selection Sort)";
    }
}

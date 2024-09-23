package ru.vaganov.naumen.task2;

import java.util.List;

public class SelectionSorter implements Task2 {
    /**
     * Вариант 4. Сортировка выбором (SelectionSort)
     * Сортировка происходит в пеерданной коллекции. Без копирования.
     *
     * @param initList массив
     */
    @Override
    public void sort(List<Double> initList) {
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

    @Override
    public String getTask() {
        return "Сортировка выбором (Selection Sort)";
    }

}

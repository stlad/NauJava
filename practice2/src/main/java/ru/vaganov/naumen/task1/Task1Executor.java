package ru.vaganov.naumen.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1Executor {
    private Task1DataProvider dataProvider;

    public Task1Executor() {
        dataProvider = new Task1DataProvider();
    }

    public void execute(Task1 task) {
        System.out.println("Задание 1: " + task.getTask());
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        Integer[] data = dataProvider.initRandoms(n);
        System.out.println("Сгенерированный массив: " + Arrays.toString(data));
        Integer result = task.findLastPositive(n, data);

        System.out.println("Результат: " + (result == null ? "Подан пустой массив" : result));
        scanner.close();
    }
}

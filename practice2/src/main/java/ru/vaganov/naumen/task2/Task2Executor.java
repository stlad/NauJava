package ru.vaganov.naumen.task2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2Executor {
    private final Task2DataProvider dataProvider;

    public Task2Executor(){
        dataProvider = new Task2DataProvider();
    }

    public void execute(Task2 task) {
        System.out.println("Задание 2: " + task.getTask());
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        List<Double> data = dataProvider.initRandoms(n);
        System.out.println("Сгенерированный список: " + covertToString(data));
        task.selectionSort(data);

        System.out.println("Отсортированный список: " + covertToString(data));
        scanner.close();
    }

    private String covertToString(List<Double> list){
        return list.stream().map(Object::toString).collect(Collectors.joining(", ","[","]"));
    }
}

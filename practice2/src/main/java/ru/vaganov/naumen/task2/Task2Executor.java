package ru.vaganov.naumen.task2;

import ru.vaganov.naumen.task1.Task1;

import java.util.Arrays;
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
        System.out.println("Сгенерированный список: " + printList(data));
        List<Double> result = task.process(data);

        System.out.println("Отсортированный список: " + printList(data));
    }

    private String printList(List<Double> list){
        return list.stream().map(Object::toString).collect(Collectors.joining(", ","[","]"));
    }
}

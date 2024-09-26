package ru.vaganov.naumen.task5;

import java.util.Scanner;

public class Task5Executor {
    private final Task5DataProvider dataProvider;

    public Task5Executor() {
        dataProvider = new Task5DataProvider();
    }

    public void execute() {
        Task5 task = new Task5(dataProvider.initQueue(50));
        System.out.println("Задание 5: " + task.getTask());
        System.out.println("Введите любую кнопку для завершения процесса");
        task.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        task.stop();
    }
}

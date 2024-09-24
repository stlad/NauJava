package ru.vaganov.naumen;

import ru.vaganov.naumen.task1.Task1;
import ru.vaganov.naumen.task1.Task1Executor;
import ru.vaganov.naumen.task2.Task2;
import ru.vaganov.naumen.task2.Task2Executor;
import ru.vaganov.naumen.task3.Task3;
import ru.vaganov.naumen.task3.Task3Executor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практическая работа 2. Вариант 4");
        System.out.println("Ваганов Владислав. РИМ-140970");
        while (true) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер задания. Или \"x\" - для завершения работы");
            System.out.println("--------------------------------------------");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "1":
                    new Task1Executor().execute(new Task1());
                case "2":
                    new Task2Executor().execute(new Task2());
                case "3":
                    new Task3Executor().execute(new Task3());
                case "4":
                    throw new UnsupportedOperationException("Еще не реализовано");
                case "x":
                    return;
                default:
                    System.out.println("Введен некорректный номер задания");
            }
        }

    }
}

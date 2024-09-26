package ru.vaganov.naumen;

import ru.vaganov.naumen.task1.Task1;
import ru.vaganov.naumen.task1.Task1Executor;
import ru.vaganov.naumen.task2.Task2;
import ru.vaganov.naumen.task2.Task2Executor;
import ru.vaganov.naumen.task3.Task3;
import ru.vaganov.naumen.task3.Task3Executor;
import ru.vaganov.naumen.task4.Task4;
import ru.vaganov.naumen.task4.Task4Executor;
import ru.vaganov.naumen.task5.Task5Executor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практическая работа 2. Вариант 4");
        System.out.println("Ваганов Владислав. РИМ-140970");
        while (true) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("--------------------------------------------");
            System.out.print("Введите номер задания (или \"q\" - для завершения работы): ");
            String input = scanner.nextLine().toLowerCase();
            System.out.println("--------------------------------------------");
            switch (input) {
                case "1":
                    new Task1Executor().execute();
                    break;
                case "2":
                    new Task2Executor().execute();
                    break;
                case "3":
                    new Task3Executor().execute();
                    break;
                case "4":
                    new Task4Executor().execute();
                    break;
                case "5":
                    new Task5Executor().execute();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Введен некорректный номер задания");
                    break;
            }
        }

    }
}

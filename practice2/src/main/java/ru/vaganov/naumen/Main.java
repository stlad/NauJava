package ru.vaganov.naumen;

import ru.vaganov.naumen.task1.LastPositiveFinder;
import ru.vaganov.naumen.task1.MaxAbsFinder;
import ru.vaganov.naumen.task1.Task1Executor;
import ru.vaganov.naumen.task2.SelectionSorter;
import ru.vaganov.naumen.task2.Task2Executor;

public class Main {
    public static void main(String[] args){
        System.out.println("Ваганов Владислав. Вариант 4");
        Task2Executor executor = new Task2Executor();
        executor.execute(new SelectionSorter());
    }
}

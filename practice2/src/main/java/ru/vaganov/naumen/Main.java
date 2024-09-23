package ru.vaganov.naumen;

import ru.vaganov.naumen.task1.LastPositiveFinder;
import ru.vaganov.naumen.task1.MaxAbsFinder;
import ru.vaganov.naumen.task1.Task1Executor;

public class Main {
    public static void main(String[] args){
        System.out.println("Ваганов Владислав. Вариант 4");
        Task1Executor executor = new Task1Executor();
        executor.execute(new LastPositiveFinder());
    }
}

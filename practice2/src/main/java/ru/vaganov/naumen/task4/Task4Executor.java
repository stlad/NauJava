package ru.vaganov.naumen.task4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task4Executor {
    public void execute(Task4 task) {
        System.out.println("Задание 4: " + task.getTask());
        String[] result = task.getAcceptHeaders();
        printArray(result);
    }

    private void printArray(String[] str) {
        System.out.println(Arrays.stream(str).map(Object::toString).collect(Collectors.joining(",\n")));
    }
}

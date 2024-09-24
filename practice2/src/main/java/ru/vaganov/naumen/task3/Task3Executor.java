package ru.vaganov.naumen.task3;

import java.util.List;
import java.util.stream.Collectors;

public class Task3Executor {

    private Task3DataProvider dataProvider;

    public Task3Executor() {
        this.dataProvider = new Task3DataProvider();
    }

    public void execute(Task3 task) {
        System.out.println("Задание 3: " + task.getTask());
        System.out.println("Исходные данные:");
        List<Employee> employees = dataProvider.initData();
        printList(employees);
        System.out.println("Результат:");
        List<String> result = task.process(employees);
        printList(result);
    }

    private void printList(List<?> list){
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(",\n")));
    }
}

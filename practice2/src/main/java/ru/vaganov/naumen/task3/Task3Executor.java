package ru.vaganov.naumen.task3;

import ru.vaganov.naumen.task2.Task2;

import java.util.List;
import java.util.stream.Collectors;

public class Task3Executor {

    private Task3DataProvider dataProvider;

    public Task3Executor() {
        this.dataProvider = new Task3DataProvider();
    }

    public void execute(Task3 task) {
        List<Employee> employees = dataProvider.initData();
        printList(employees);
        System.out.println("-----");
        List<String> result = task.process(employees);
        printList(result);
    }

    private void printList(List<?> list){
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(",\n")));
    }
}

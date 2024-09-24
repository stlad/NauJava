package ru.vaganov.naumen.task3;

import java.util.List;

public class Task3 {

    public List<String> process(List<Employee> source) {
        return source.stream().map(employee -> String.format("%s - %s", employee.getFullname(), employee.getDepartment())).toList();
    }

    public String getTask() {
        return "Преобразовать список сотрудников в список строк вида ИМЯ - ОТДЕЛ";
    }
}

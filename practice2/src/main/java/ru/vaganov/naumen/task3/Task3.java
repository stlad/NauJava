package ru.vaganov.naumen.task3;

import java.util.List;

public class Task3 {
    /**
     * @param source исходный список сотрудников
     * @return список строк формата "ФИО - отдел"
     */
    public List<String> process(List<Employee> source) {
        return source.stream().map(employee ->
                String.format("%s - %s",
                        employee.getFullname() == null ? "<нет имени>" : employee.getFullname(),
                        employee.getDepartment() == null ? "<отдел указан>" : employee.getDepartment()))
                .toList();
    }

    public String getTask() {
        return "Преобразовать список сотрудников в список строк вида ИМЯ - ОТДЕЛ";
    }
}

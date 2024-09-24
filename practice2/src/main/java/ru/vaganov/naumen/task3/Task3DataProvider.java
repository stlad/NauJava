package ru.vaganov.naumen.task3;

import java.util.Arrays;
import java.util.List;

public class Task3DataProvider {
    public List<Employee> initData(){
        return Arrays.asList(
                new Employee("Иван",20,50000., "Отдел разработки"),
                new Employee("Андрей",24,50000., "Отдел тестирования"),
                new Employee("Никита",55,150000., "Отдел разработки"),
                new Employee("Антон",40,80000., "Отдел тестирования"),
                new Employee("Анна",22,55500., "Отдел аналитики"),
                new Employee("Мария",32,50000., "Отдел аналитики")
        );
    }
}

package ru.vaganov.naumen.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class Task3Test {

    private Task3 task3;

    @BeforeEach
    void init() {
        this.task3 = new Task3();
    }

    @Test
    @DisplayName("Преобразовать список сотрудников: заглушки, когда не указаны ФИО и Отдел")
    void process_mockMessage_WhenNull() {
        List<Employee> employees = List.of(new Employee(null, null, null, null));

        List<String> result = task3.process(employees);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("<нет имени> - <отдел указан>", result.get(0));
    }

    @Test
    @DisplayName("Преобразовать список сотрудников: заглушки, когда не указаны ФИО и Отдел")
    void process_mockFullNameMessage_WhenNull() {
        List<Employee> employees = List.of(new Employee(null, null, null, "отдел продаж"));

        List<String> result = task3.process(employees);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("<нет имени> - отдел продаж", result.get(0));
    }

    @Test
    @DisplayName("Преобразовать список сотрудников: несколько сотрудников")
    void process_positiveCase() {
        List<Employee> employees = List.of(
                new Employee("Иванов Иван Иванович", null, null, "отдел продаж"),
                new Employee("Андреев Андрей Андреевич", null, null, "отдел разработки")
        );

        List<String> result = task3.process(employees);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Иванов Иван Иванович - отдел продаж", result.get(0));
        Assertions.assertEquals("Андреев Андрей Андреевич - отдел разработки", result.get(1));
    }
}
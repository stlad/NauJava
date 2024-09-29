package ru.naumen.vagnov.naujava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data //Добавим get() set() методы ко всем приватным полям. Переопределим equals() hashcode() для данного класса
@Builder // Добавим фабричный метод для более удобного создания объекта через методы User.builder()....build()
@AllArgsConstructor //добавим конструктор со всеми аргументами
public class User {
    private Long id;
    private String email;
    private String login;
}

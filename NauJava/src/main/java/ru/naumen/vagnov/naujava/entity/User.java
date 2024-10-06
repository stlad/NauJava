package ru.naumen.vagnov.naujava.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder // Добавим фабричный метод для более удобного создания объекта через методы User.builder()....build()
@AllArgsConstructor //добавим конструктор со всеми аргументами
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator
    private UUID id;

    private String email;

    private String login;

    private LocalDateTime registeredAt;

    private String password;

    private boolean isBanned;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}

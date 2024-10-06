package ru.naumen.vagnov.naujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naumen.vagnov.naujava.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    //method query запрос
    Optional<User> findByEmailOrLogin(String email, String login);
}

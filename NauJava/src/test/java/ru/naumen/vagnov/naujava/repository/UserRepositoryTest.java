package ru.naumen.vagnov.naujava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.naumen.vagnov.naujava.BaseContextTest;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.service.UserService;

class UserRepositoryTest extends BaseContextTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    @DisplayName("JPQL query тест")
    @Transactional
    void findByEmailOrLogin() {
        Assertions.assertEquals(0, userRepository.findAll().size());
        userService.registerUser("TestLogin", "testemail@example.com", "password");

        User result = userRepository.findByLogin("TestLogin").orElseThrow();

        Assertions.assertEquals("TestLogin", result.getLogin());
        Assertions.assertEquals("testemail@example.com", result.getEmail());
    }

    @Test
    @DisplayName("Method Query тест")
    @Transactional
    void findByLogin() {
        Assertions.assertEquals(0, userRepository.findAll().size());
        userService.registerUser("TestLogin", "testemail@example.com", "password");

        User result = userRepository.findByEmailOrLogin("non existing email", "TestLogin").orElseThrow();

        Assertions.assertEquals("TestLogin", result.getLogin());
        Assertions.assertEquals("testemail@example.com", result.getEmail());
    }
}
package ru.naumen.vagnov.naujava.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naumen.vagnov.naujava.entity.Chat;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.service.ChatService;
import ru.naumen.vagnov.naujava.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/")
@Tag(name = "User API")
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    private final ChatService chatService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/user/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(
                userService.registerUser(user.getLogin(), user.getEmail(), user.getPassword()),
                HttpStatus.OK);
    }

    @Operation(summary = "Создание чата")
    @PostMapping("/chat/create")
    public ResponseEntity<Chat> createChat(@RequestParam String login,
                                           @RequestParam String title,
                                           @RequestParam String description) {
        return new ResponseEntity<>(
                chatService.createChat(login, title,description),
                HttpStatus.OK);
    }
}

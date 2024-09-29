package ru.naumen.vagnov.naujava.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.naumen.vagnov.naujava.service.UserService;

@Component
@RequiredArgsConstructor
public class CommandProcessor {
    private final UserService userService;

    public void processCommand(String input) {
        try {
            String[] cmd = input.split(" ");
            switch (cmd[0]) {
                case "create" -> {
                    userService.createUser(Long.valueOf(cmd[1]), cmd[2]);
                    System.out.println("Пользователь успешно добавлен...");
                }
                case "get" -> {
                    var user = userService.findById(Long.valueOf(cmd[1]));
                    System.out.println("Пользователь: " + user);
                }
                case "update" -> {
                    userService.updateLogin(Long.valueOf(cmd[1]), cmd[2]);
                    System.out.println("Пользователь успешно обновлен...");
                }
                case "delete" -> {
                    userService.deleteById(Long.valueOf(cmd[1]));
                    System.out.println("Пользователь успешно удален...");
                }
                // …. здесь логика Обработки других команды
                default -> System.out.println("Введена неизвестная команда...");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package ru.naumen.vagnov.naujava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.naumen.vagnov.naujava.entity.Chat;
import ru.naumen.vagnov.naujava.entity.Message;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.repository.MessageRepository;
import ru.naumen.vagnov.naujava.repository.criteria.MessageCriteriaRepository;
import ru.naumen.vagnov.naujava.service.ChatService;
import ru.naumen.vagnov.naujava.service.UserService;

public class CriteriaRepositoryTests extends BaseContextTest {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageCriteriaRepository messageCriteriaRepository;
    @Autowired
    private ChatService chatService;

    @Test
    @DisplayName("Criteria тест")
    @Transactional
    void findByEmailOrLogin() {
        User user = userService.registerUser("TestLogin", "testemail@example.com", "password");
        Chat chat = chatService.createChat("TestLogin", "Test chat", "");
        Message message = chatService.sendMessage(chat.getId(), user.getLogin(), "hello world");

        Message result = messageCriteriaRepository.findByAuthorLogin("TestLogin").get(0);

        Assertions.assertEquals("TestLogin", result.getAuthor().getLogin());
        Assertions.assertEquals("hello world", message.getContent());
    }
}

package ru.naumen.vagnov.naujava.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naumen.vagnov.naujava.entity.Chat;
import ru.naumen.vagnov.naujava.entity.ChatMember;
import ru.naumen.vagnov.naujava.entity.Message;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.enums.ChatRole;
import ru.naumen.vagnov.naujava.repository.ChatRepository;
import ru.naumen.vagnov.naujava.repository.MessageRepository;
import ru.naumen.vagnov.naujava.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @Transactional
    public Chat createChat(String login, String title, String description){
        User admin = userRepository.findByLogin(login)
                .orElseThrow(()-> new EntityNotFoundException("Такой пользователь не найден или заблокирован"));
        Chat chat = Chat.builder()
                .createdAt(LocalDateTime.now())
                .description(description)
                .title(title)
                .members(Set.of(
                        ChatMember.builder()
                                .user(admin)
                                .joinedAt(LocalDateTime.now())
                                .chatRole(ChatRole.ADMIN)
                                .build()
                ))
                .build();
        return chatRepository.save(chat);
    }

    @Transactional
    public Message sendMessage(UUID targetChartId, String userLogin, String content){
        User user = userRepository.findByLogin(userLogin)
                .orElseThrow(()-> new EntityNotFoundException("Такой пользователь не найден или заблокирован"));
        Chat chat = chatRepository.findById(targetChartId)
                .orElseThrow(()-> new EntityNotFoundException("Нет такого чата"));

        Message message = Message.builder()
                .chat(Set.of(chat))
                .author(user)
                .content(content)
                .postedAt(LocalDateTime.now())
                .build();

        return messageRepository.save(message);
    }
}

package ru.naumen.vagnov.naujava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @UuidGenerator
    private UUID id;

    private String description;
    private String title;
    private LocalDateTime createdAt;


    @ManyToMany
    @JoinTable(
            name = "chat_messages",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> messages;
}

package ru.naumen.vagnov.naujava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.naumen.vagnov.naujava.enums.ChatRole;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chat_members")
public class ChatMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Chat chat;

    @Enumerated(EnumType.STRING)
    private ChatRole chatRole;

    private LocalDateTime joinedAt;
}

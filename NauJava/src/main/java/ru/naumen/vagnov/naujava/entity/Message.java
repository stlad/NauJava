package ru.naumen.vagnov.naujava.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {
    @Id
    @UuidGenerator
    private UUID id;

    private String content;

    private LocalDateTime postedAt;

    @OneToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User author;

    @ManyToMany(mappedBy = "messages")
    private Set<Chat> chat;
}

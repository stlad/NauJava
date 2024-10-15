package ru.naumen.vagnov.naujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.naumen.vagnov.naujava.entity.Chat;

import java.util.UUID;

@Repository
@RepositoryRestResource
public interface ChatRepository extends JpaRepository<Chat, UUID> {
}

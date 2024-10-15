package ru.naumen.vagnov.naujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.naumen.vagnov.naujava.entity.ChatMember;

@Repository
@RepositoryRestResource
public interface ChatMemberRepository extends JpaRepository<ChatMember, Long> {
}

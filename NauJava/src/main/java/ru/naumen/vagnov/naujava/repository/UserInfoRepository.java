package ru.naumen.vagnov.naujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.naumen.vagnov.naujava.entity.UserInfo;

import java.util.UUID;

@Repository
@RepositoryRestResource
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {
}

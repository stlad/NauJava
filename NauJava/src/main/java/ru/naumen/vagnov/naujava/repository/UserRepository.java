package ru.naumen.vagnov.naujava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.naumen.vagnov.naujava.entity.User;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    //method query запрос
    Optional<User> findByEmailOrLogin(String email, String login);

    @Query("SELECT u FROM User u " +
            "WHERE u.login = :login " +
            "AND u.isBanned = false ")
    Optional<User> findByLogin(String login);
}

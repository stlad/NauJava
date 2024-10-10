package ru.naumen.vagnov.naujava.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.naumen.vagnov.naujava.entity.Chat;
import ru.naumen.vagnov.naujava.entity.Message;
import ru.naumen.vagnov.naujava.entity.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageCriteriaRepositoryImpl implements MessageCriteriaRepository {

    private final EntityManager entityManager;
    @Override
    public List<Message> findByAuthorLogin(String login) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);

        Root<Message> messageRoot = criteriaQuery.from(Message.class);
        Join<Message, User> user = messageRoot.join("author", JoinType.INNER);
        Predicate loginPredicate = criteriaBuilder.equal(user.get("login"), login);

        criteriaQuery.select(messageRoot).where(loginPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

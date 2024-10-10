package ru.naumen.vagnov.naujava.repository.criteria;

import ru.naumen.vagnov.naujava.entity.Message;

import java.util.List;

public interface MessageCriteriaRepository {

    List<Message> findByAuthorLogin(String login);
}

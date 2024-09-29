package ru.naumen.vagnov.naujava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.naumen.vagnov.naujava.exceptions.NaumenEntityNotFoundException;
import ru.naumen.vagnov.naujava.model.User;

import java.util.List;

@Component
public class UserRepository implements CrudRepository<User, Long> {
    private final List<User> userContainer;

    @Autowired
    public UserRepository(List<User> userContainer) {
        this.userContainer = userContainer;
    }

    @Override
    public void create(User entity) {
        userContainer.add(entity);
    }

    @Override
    public User read(Long id) {
        return userContainer.stream().filter(u -> u.getId().equals(id)).findAny()
                .orElseThrow(() -> new NaumenEntityNotFoundException("Не удалось найти пользователя с id: " + id));
    }

    @Override
    public void update(User entity) {
        var foundUser = userContainer.stream().filter(u -> u.getId() == entity.getId()).findAny()
                .orElseThrow(() -> new NaumenEntityNotFoundException("Не удалось найти пользователя с id: " + entity.getId()));
        foundUser.setEmail(entity.getEmail());
        foundUser.setLogin(entity.getLogin());
    }

    @Override
    public void delete(Long id) {
        userContainer.removeIf(u -> u.getId().equals(id));
    }
}

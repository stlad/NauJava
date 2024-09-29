package ru.naumen.vagnov.naujava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.repository.UserRepository;

@Service
@RequiredArgsConstructor //Конструктор с используемыми полями.
//В данном случае userRepository внедрится именно через этот КОНСТРУКТОР и нет необходимости использовать @Autowired
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public void createUser(Long id, String login) {
        userRepository.create(
                User.builder().id(id).login(login).build()
        );
    }

    @Override
    public User findById(Long id) {
        return userRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void updateLogin(Long id, String newLogin) {
        var foundUser = userRepository.read(id);
        foundUser.setLogin(newLogin);
        userRepository.update(foundUser);
    }
}

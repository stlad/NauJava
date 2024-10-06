package ru.naumen.vagnov.naujava.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naumen.vagnov.naujava.entity.User;
import ru.naumen.vagnov.naujava.entity.UserInfo;
import ru.naumen.vagnov.naujava.repository.UserInfoRepository;
import ru.naumen.vagnov.naujava.repository.UserRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserInfoRepository infoRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public User registerUser(String login, String email, String password) {
        if (userRepository.findByEmailOrLogin(email, login).isPresent()) {
            throw new EntityExistsException("Уже существует пользователь с таким логином или почтой");
        }

        User user = User.builder()
                .login(login)
                .email(email)
                .password(encoder.encode(password))
                .registeredAt(LocalDateTime.now())
                .build();
        user = userRepository.save(user);
        UserInfo userInfo = UserInfo.builder().user(user).build();
        infoRepository.save(userInfo);
        return user;
    }
}

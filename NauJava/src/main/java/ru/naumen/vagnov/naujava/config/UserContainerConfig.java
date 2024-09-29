package ru.naumen.vagnov.naujava.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.naumen.vagnov.naujava.entity.User;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserContainerConfig {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON) // можно не указывать. По умолчанию скоуп бинов - singleton
    public List<User> userContainer() {
        return new ArrayList<>();
    }
}

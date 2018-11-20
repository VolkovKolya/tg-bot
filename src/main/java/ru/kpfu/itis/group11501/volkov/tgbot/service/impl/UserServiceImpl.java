package ru.kpfu.itis.group11501.volkov.tgbot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.volkov.tgbot.model.User;
import ru.kpfu.itis.group11501.volkov.tgbot.repository.UserRepository;
import ru.kpfu.itis.group11501.volkov.tgbot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByNames(String firstName, String secondName, String thirdName) {
        return userRepository.getOneByFirstNameAndSecondNameAndThirdName(firstName,secondName,thirdName);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

package ru.kpfu.itis.group11501.volkov.tgbot.service;

import ru.kpfu.itis.group11501.volkov.tgbot.model.User;

public interface UserService {
    User getUserByNames(String firstName, String secondName, String thirdName);
    User addUser(User user);
    User updateUser(User user);
}

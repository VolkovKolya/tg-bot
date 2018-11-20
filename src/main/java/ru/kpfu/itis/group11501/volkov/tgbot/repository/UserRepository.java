package ru.kpfu.itis.group11501.volkov.tgbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.group11501.volkov.tgbot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User getOneByFirstNameAndSecondNameAndThirdName(String firstName, String secondName, String thirdName);
}

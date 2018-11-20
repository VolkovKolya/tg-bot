package ru.kpfu.itis.group11501.volkov.tgbot.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.MessageHandler;
import ru.kpfu.itis.group11501.volkov.tgbot.model.User;
import ru.kpfu.itis.group11501.volkov.tgbot.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FIOMessageHandler implements MessageHandler {

    private static final String PATTERN = "^[a-zA-Z]{2,20}\\s[a-zA-Z]{2,20}\\s[a-zA-Z]{2,20}$";
    private final UserService userService;

    @Autowired
    public FIOMessageHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public SendMessage process(Message message) {
        String text = message.getText();
        String outText;

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()){
            String[] names = text.split(" ");
            User user = userService.getUserByNames(names[0],names[1],names[2]);
            if (user!= null) outText = user.toString();
            else outText = "Not found!";
        }
        else outText = "Wrong expression!";

        return new SendMessage()
                .setChatId(message.getChatId())
                .setText(outText);
    }

    @Override
    public boolean canProcess(Message message) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(message.getText());
        return matcher.matches();
    }
}

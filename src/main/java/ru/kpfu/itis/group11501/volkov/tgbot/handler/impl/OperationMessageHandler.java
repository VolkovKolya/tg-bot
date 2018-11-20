package ru.kpfu.itis.group11501.volkov.tgbot.handler.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.MessageHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class OperationMessageHandler implements MessageHandler {

    private static final String PATTERN = "^[/][a-z]{1,20}$";
    @Override
    public SendMessage process(Message message) {

        switch (message.getText()){
            case "/start":
                return new SendMessage()
                        .setChatId(message.getChatId())
                        .setText("Hello");
            default:
                return new SendMessage()
                    .setChatId(message.getChatId())
                    .setText("Cant'n do this operation");
        }

    }

    @Override
    public boolean canProcess(Message message) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(message.getText());
        return matcher.matches();
    }
}

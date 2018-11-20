package ru.kpfu.itis.group11501.volkov.tgbot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageHandler {
    SendMessage process(Message message);
    boolean canProcess(Message message);
}

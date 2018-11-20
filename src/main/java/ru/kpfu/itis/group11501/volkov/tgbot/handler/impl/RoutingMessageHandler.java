package ru.kpfu.itis.group11501.volkov.tgbot.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.MessageHandler;
import java.util.List;

@Component
public class RoutingMessageHandler implements MessageHandler {

    private List<MessageHandler> messageHandlerList;
    @Autowired
    public RoutingMessageHandler(List<MessageHandler> messageHandlerList) {
        this.messageHandlerList = messageHandlerList;
    }

    @Override
    public SendMessage process(Message message) {
        for (MessageHandler handler: messageHandlerList){
            if (handler.canProcess(message)) return handler.process(message);
        }
        return new SendMessage()
                .setChatId(message.getChatId())
                .setText("Can't find anything for you request");
    }

    @Override
    public final boolean canProcess(Message message) {
        return false;
    }
}

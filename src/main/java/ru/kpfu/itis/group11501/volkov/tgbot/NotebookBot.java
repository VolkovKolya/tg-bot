package ru.kpfu.itis.group11501.volkov.tgbot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.MessageHandler;

public class NotebookBot extends TelegramLongPollingBot {

    private String botUsername;
    private String botToken;
    private MessageHandler handler;

    public NotebookBot(String botUsername, String botToken, MessageHandler handler) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.handler = handler;
    }

    public NotebookBot(DefaultBotOptions options, String botUsername, String botToken, MessageHandler handler) {
        super(options);
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.handler = handler;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = handler.process(update.getMessage());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }



}

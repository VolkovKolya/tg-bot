package ru.kpfu.itis.group11501.volkov.tgbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.kpfu.itis.group11501.volkov.tgbot.NotebookBot;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.MessageHandler;
import ru.kpfu.itis.group11501.volkov.tgbot.handler.impl.RoutingMessageHandler;

import java.util.List;

@Configuration
@PropertySource("classpath:bot.properties")
public class BotConfig {

    private Environment env;

    @Autowired
    public BotConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public NotebookBot notebookBot(@Qualifier(value = "routingMessageHandler") MessageHandler messageHandler){
        String botUsername = env.getProperty("bot.botUsername");
        String botToken = env.getProperty("bot.botToken");
        NotebookBot notebookBot= new NotebookBot(botUsername,botToken,messageHandler);
        return  notebookBot;
    }

}

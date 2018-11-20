package ru.kpfu.itis.group11501.volkov.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@PropertySource("classpath:/application.properties")
@EnableJpaRepositories("ru.kpfu.itis.group11501.volkov.tgbot.repository")
public class TgBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(TgBotApplication.class, args);
	}
}

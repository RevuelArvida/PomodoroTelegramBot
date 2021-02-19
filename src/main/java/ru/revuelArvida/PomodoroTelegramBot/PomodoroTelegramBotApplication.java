package ru.revuelArvida.PomodoroTelegramBot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PomodoroTelegramBotApplication {

	static PomodoroBot bot;

	public static void main(String[] args) {
		SpringApplication.run(PomodoroTelegramBotApplication.class, args);
	}
}

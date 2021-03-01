package ru.revuelArvida.pomodoroTelegramBot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.revuelArvida.pomodoroTelegramBot.bot.PomodoroBot;


@SpringBootApplication
public class PomodoroTelegramBotApplication {

	static PomodoroBot bot;

	public static void main(String[] args) {
		SpringApplication.run(PomodoroTelegramBotApplication.class, args);
	}
}

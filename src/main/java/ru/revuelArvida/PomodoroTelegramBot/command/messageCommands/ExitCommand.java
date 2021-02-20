package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;



public class ExitCommand implements Command {



    private final SendMessageService sendMessageService;
    private final String EXIT_MESSAGE = "Возвращаемся в главное меню";

    public ExitCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }



    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), EXIT_MESSAGE);
    }
}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class StopCommand implements Command {

    private final SendMessageService sendMessageService;
    public final static String STOP_MESSAGE = "Прекращаем работу, возвращаемся в главное меню";

    public StopCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.botCommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;


/**
 * Implementation of {@link Command} interface for STOP {@link CommandName}
 *
 * @author RevuelArvida
 */
class StopCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String STOP_MESSAGE = "Бот остановлен, все данные удалены!";

    @Autowired
    public StopCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}

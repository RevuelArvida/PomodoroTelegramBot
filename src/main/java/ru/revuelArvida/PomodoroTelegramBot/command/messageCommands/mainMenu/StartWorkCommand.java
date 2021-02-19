package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;


/**
 * Implementation of {@link Command} interface for WORK {@link Command}
 *
 * @author RevuelArvida
 */
public class StartWorkCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String START_WORK = "Начинаем работу, но не начинаем";

    public StartWorkCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(),
                START_WORK);
    }
}

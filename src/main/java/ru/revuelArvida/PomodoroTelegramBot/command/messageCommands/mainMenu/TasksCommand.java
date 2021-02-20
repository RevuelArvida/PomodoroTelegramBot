package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

/**
 * Implementation of {@link Command} interface for TASK {@link Command}
 *
 * @author RevuelArvida
 */
class TasksCommand implements Command {

    private final SendMessageService sendMessageService;

    private final static String TASK_MESSAGE = "Вы перешли в меню задач!";

    public TasksCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), TASK_MESSAGE);
    }
}

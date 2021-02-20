package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class ChangeCommand implements Command {
    private final SendMessageService sendMessageService;

    private final static String CHANGE_COMMAND_MESSAGE = "Вы решили изменить задачу";

    public ChangeCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(),
                CHANGE_COMMAND_MESSAGE);
    }
}

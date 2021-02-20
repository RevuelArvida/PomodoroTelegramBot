package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class AddFirstCommand implements Command {

    private final SendMessageService sendMessageService;

    private final static String ADD_COMMAND_MESSAGE = "Вы решили добавить задачу в начало списка";

    public AddFirstCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), ADD_COMMAND_MESSAGE);
    }
}

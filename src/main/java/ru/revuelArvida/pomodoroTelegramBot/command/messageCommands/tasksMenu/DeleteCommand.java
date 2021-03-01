package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

class DeleteCommand implements Command {
    private final SendMessageService sendMessageService;

    public final static String DELETE_COMMAND_MESSAGE = "Вы решили удалить задачу";

    public DeleteCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), DELETE_COMMAND_MESSAGE);
    }
}

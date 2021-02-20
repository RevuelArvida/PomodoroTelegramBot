package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class DeleteCommand implements Command {
    private final SendMessageService sendMessageService;

    private final static String DELETE_COMMAND_MESSAGE = "Вы решили удалить задачу";

    public DeleteCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), DELETE_COMMAND_MESSAGE);
    }
}

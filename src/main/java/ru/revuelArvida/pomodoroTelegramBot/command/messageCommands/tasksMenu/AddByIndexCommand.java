package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

class AddByIndexCommand implements Command {
    private final SendMessageService sendMessageService;

   public final static String ADD_COMMAND_MESSAGE = "Вы решили добавить задачу " +
            "по индексу";

    public AddByIndexCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), ADD_COMMAND_MESSAGE);
    }
}

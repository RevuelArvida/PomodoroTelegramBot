package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;



class StartWorkCommand implements Command {

    private final SendMessageService sendMessageService;
    private final String START_WORK_MESSAGE = "Приступаем к работе";

    public StartWorkCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_WORK_MESSAGE);
    }
}

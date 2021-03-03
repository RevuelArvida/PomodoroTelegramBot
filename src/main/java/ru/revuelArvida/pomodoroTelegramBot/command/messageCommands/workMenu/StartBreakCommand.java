package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

class StartBreakCommand implements Command {

    private final SendMessageService sendMessageService;
    public static final String START_BREAK_MESSAGE = "Отдыхаем";

    public StartBreakCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_BREAK_MESSAGE);
    }
}
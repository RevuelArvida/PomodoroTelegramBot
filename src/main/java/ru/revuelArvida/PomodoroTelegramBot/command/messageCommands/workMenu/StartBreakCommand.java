package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class StartBreakCommand implements Command {

    private final SendMessageService sendMessageService;
    private final String START_BREAK_MESSAGE = "Отдыхаем";

    public StartBreakCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_BREAK_MESSAGE);
    }
}
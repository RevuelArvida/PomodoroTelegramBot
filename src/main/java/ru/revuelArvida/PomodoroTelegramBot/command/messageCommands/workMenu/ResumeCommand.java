package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class ResumeCommand implements Command {

    private final SendMessageService sendMessageService;
    public final static String RESUME_MESSAGE = "Продолжаем";

    public ResumeCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), RESUME_MESSAGE);
    }
}

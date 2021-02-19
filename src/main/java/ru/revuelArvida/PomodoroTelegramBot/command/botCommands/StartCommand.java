package ru.revuelArvida.PomodoroTelegramBot.command.botCommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

/**
 * Implementation of {@link Command} interface for START {@link CommandName}
 *
 * @author RevuelArvida
 */

public class StartCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String START_MESSAGE = "Привет, я - твой личный тайм менеджер, сообщу " +
            "тебе когда ты в помидоре, а когда следует отдохнуть!";

    @Autowired
    public StartCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }

}

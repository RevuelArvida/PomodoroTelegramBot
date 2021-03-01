package ru.revuelArvida.pomodoroTelegramBot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.botCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;


/**
 * Implementation of {@link Command} interface for UnknownCommand {@link CommandName}
 *
 * @author RevuelArvida
 */
public class UnknownCommand implements Command {

    private final SendMessageService sendMessageService;

    private static final String UNKNOWN_COMMAND_MESSAGE = "Нет такой команды, напишите /help," +
            "чтобы узнать команды, которые я знаю, или воспользуйтесь кнопками на клавиатуре.";

    @Autowired
    public UnknownCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(),
                UNKNOWN_COMMAND_MESSAGE);
    }
}

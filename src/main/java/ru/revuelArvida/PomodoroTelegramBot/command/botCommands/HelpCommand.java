package ru.revuelArvida.PomodoroTelegramBot.command.botCommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandName.*;


/**
 * Implementation of {@link Command} interface for HELP {@link CommandName}
 *
 * @author RevuelArvida
 */
public class HelpCommand implements Command {

    private final SendMessageService sendMessageService;

    public static final String HELP_MESSAGE = String.format("Доступные команды: \n\n"
            + "%s - Начать работу с ботом\n"
            + "%s - Остановить работу с ботом и сбросить настройки. \n"
            + "%s - Помощь",
            START.getCommandName(), STOP.getCommandName(),HELP.getCommandName());



    @Autowired
    public HelpCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(),HELP_MESSAGE);
    }
}

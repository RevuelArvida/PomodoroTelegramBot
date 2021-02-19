package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.State;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.WaitState;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import javax.annotation.PostConstruct;

public class ExitCommand implements Command {


    private State state;
    private final SendMessageService sendMessageService;
    public final static String EXIT_MESSAGE = "Возврат в главное меню";

    public ExitCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @PostConstruct
    public void init(CommandContainersContainer container){
        this.state = new WaitState(container);
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), EXIT_MESSAGE);
    }
}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.PersonalSettingsState;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.State;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import javax.annotation.PostConstruct;

public class PersonalCommand implements Command {

    private State state;

    private final SendMessageService sendMessageService;

    public final static String PERSONAL_SETTINGS_MESSAGE = "Отлично, введите пожалуйста " +
            "продолжительность рабочего периода";

    public PersonalCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @PostConstruct
    public void init(CommandContainersContainer container){
        this.state = new PersonalSettingsState(container);
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), PERSONAL_SETTINGS_MESSAGE);
    }
}

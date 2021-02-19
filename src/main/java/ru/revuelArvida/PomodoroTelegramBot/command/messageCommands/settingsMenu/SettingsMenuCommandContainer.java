package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.SuperState;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;
import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsCommandName.*;

/**
 * Container of the {@link Command}'s for handling message commands in Settings State
 */

@Component
@Scope("singleton")
public class SettingsMenuCommandContainer implements Container {

    private final PomodoroBot bot;
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    @Autowired
    public SettingsMenuCommandContainer(SendMessageService sendMessageService, PomodoroBot bot){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(DEFAULT.getCommandName(), new DefaultCommand(sendMessageService))
                .put(PERSONAL.getCommandName(), new PersonalCommand(sendMessageService))
                .put(EXIT.getCommandName(), new ExitCommand(sendMessageService))
                .build();
        this.bot = bot;
        unknownCommand = new UnknownCommand(sendMessageService);
    }


@Override
    public Command retrieveCommand(String commandIdentifier) {
        SuperState superState = bot.getSuperState();
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (command instanceof PersonalCommand){
            bot.changeState(superState.getPersonalSettingsState());
        } else bot.changeState(superState.getWaitState());
        return command;
    }
}

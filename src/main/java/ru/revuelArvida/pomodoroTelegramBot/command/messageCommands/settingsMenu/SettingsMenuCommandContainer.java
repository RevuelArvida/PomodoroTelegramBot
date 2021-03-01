package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.Container;
import ru.revuelArvida.pomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.ExitCommand;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsCommandName.*;

/**
 * Container of the {@link Command}'s for handling message commands in Settings State
 */

@Component
@Scope("singleton")
public class SettingsMenuCommandContainer implements Container {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;


    public SettingsMenuCommandContainer(SendMessageService sendMessageService){


        commandMap = ImmutableMap.<String, Command>builder()
                .put(DEFAULT.getCommandName(), new DefaultCommand(sendMessageService))
                .put(PERSONAL.getCommandName(), new PersonalCommand(sendMessageService))
                .put(EXIT.getCommandName(), new ExitCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }


@Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (command instanceof PersonalCommand){
            stateContext.setState(StateList.PERSONAL_SETTINGS);
        } else stateContext.setState(StateList.SLEEP);
        return command;
    }
}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.SuperState;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.*;


@Component
@Scope("singleton")
public class MainMenuCommandContainer implements Container {

    private final PomodoroBot bot;
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public MainMenuCommandContainer(SendMessageService sendMessageService, PomodoroBot bot){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(WORK.getCommandName(), new StartWorkCommand(sendMessageService))
                .put(TASKS.getCommandName(), new TasksCommand(sendMessageService) )
                .put(SETTINGS.getCommandName(), new SettingsCommand(sendMessageService))
                .build();
        this.bot = bot;
        unknownCommand = new UnknownCommand(sendMessageService);
    }

    @Override
    public Command retrieveCommand(String commandIdentifier) {
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        SuperState superState = bot.getSuperState();
        if(command instanceof SettingsCommand){
            bot.changeState(superState.getSettingsState());
        } else if(command instanceof StartWorkCommand){

        }
        return command;
    }

}

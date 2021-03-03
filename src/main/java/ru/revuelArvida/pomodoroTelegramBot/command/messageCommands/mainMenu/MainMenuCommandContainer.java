package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.Container;
import ru.revuelArvida.pomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.*;


@Component
@Scope("singleton")
public class MainMenuCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public MainMenuCommandContainer(SendMessageService sendMessageService){

        commandMap = ImmutableMap.<String, Command>builder()
                .put(WORK.getCommandName(), new StartWorkCommand(sendMessageService))
                .put(TASKS.getCommandName(), new TasksCommand(sendMessageService) )
                .put(SETTINGS.getCommandName(), new SettingsCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }



    @Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if(command instanceof SettingsCommand){
            stateContext.setState(StateList.SETTINGS);
        } else if(command instanceof StartWorkCommand){
            stateContext.setState(StateList.WORK);
        } else if (command instanceof TasksCommand){
            stateContext.setState(StateList.TASK);
        }
        return command;
    }

}

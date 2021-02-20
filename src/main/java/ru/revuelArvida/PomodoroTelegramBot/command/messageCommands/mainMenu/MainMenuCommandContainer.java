package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu.TasksMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu.WorkMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.*;


@Component
@Scope("singleton")
public class MainMenuCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    @Getter
    private final SettingsMenuCommandContainer settingsMenuCommandContainer;
    @Getter
    private final TasksMenuCommandContainer tasksMenuCommandContainer;
    @Getter
    private final WorkMenuCommandContainer workMenuCommandContainer;


    public MainMenuCommandContainer(SendMessageService sendMessageService){

        this.tasksMenuCommandContainer = new TasksMenuCommandContainer(sendMessageService);
        this.settingsMenuCommandContainer =
                new SettingsMenuCommandContainer(sendMessageService);
        this.workMenuCommandContainer = new WorkMenuCommandContainer(sendMessageService);


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

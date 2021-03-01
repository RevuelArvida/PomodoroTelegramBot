package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.Container;
import ru.revuelArvida.pomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.ExitCommand;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName.*;

@Component
public class TasksMenuCommandContainer implements Container {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public TasksMenuCommandContainer(SendMessageService sendMessageService){
        unknownCommand = new UnknownCommand(sendMessageService);

        commandMap = ImmutableMap.<String, Command>builder()
                .put(ADD.getCommandName(), new AddCommand(sendMessageService))
                .put(ADD_FIRST.getCommandName(), new AddFirstCommand(sendMessageService))
                .put(ADD_AT_INDEX.getCommandName(), new AddByIndexCommand(sendMessageService))
                .put(CHANGE.getCommandName(), new ChangeCommand(sendMessageService))
                .put(DELETE.getCommandName(), new DeleteCommand(sendMessageService))
                .put(EXIT.getCommandName(), new ExitCommand(sendMessageService))
                .build();
    }

    @Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);

        if (command instanceof AddByIndexCommand
                || command instanceof ChangeCommand
                || command instanceof DeleteCommand){

        } else if (command instanceof ExitCommand){
            stateContext.setState(StateList.SLEEP);
        }
        return command;
    }
}

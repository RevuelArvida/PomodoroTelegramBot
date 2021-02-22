package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;

import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.*;

@Component
public class WorkMenuCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public WorkMenuCommandContainer(SendMessageService sendMessageService){

        commandMap = ImmutableMap.<String, Command>builder()
                .put(STARTWORK.getCommandName(), new StartWorkCommand(sendMessageService))
                .put(STARTBREAK.getCommandName(), new StartBreakCommand(sendMessageService))
                .put(PAUSE.getCommandName(), new PauseCommand(sendMessageService))
                .put(RESUME.getCommandName(), new ResumeCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }


    @Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        Command command = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (command instanceof StopCommand){
            stateContext.setState(StateList.SLEEP);
        }
        return command;
    }
}

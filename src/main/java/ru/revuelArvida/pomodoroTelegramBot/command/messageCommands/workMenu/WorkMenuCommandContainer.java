package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import com.google.common.collect.ImmutableMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.Container;
import ru.revuelArvida.pomodoroTelegramBot.command.UnknownCommand;

import ru.revuelArvida.pomodoroTelegramBot.service.SchedulerService;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.*;

@Component
@Scope("prototype")
public class WorkMenuCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public WorkMenuCommandContainer(SendMessageService sendMessageService, SchedulerService schedulerService){

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START_WORK.getCommandName(), new StartWorkCommand(sendMessageService, schedulerService))
                .put(START_BREAK.getCommandName(), new StartBreakCommand(sendMessageService, schedulerService))
                .put(PAUSE.getCommandName(), new PauseCommand(sendMessageService, schedulerService))
                .put(RESUME.getCommandName(), new StartWorkCommand(sendMessageService, schedulerService))
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

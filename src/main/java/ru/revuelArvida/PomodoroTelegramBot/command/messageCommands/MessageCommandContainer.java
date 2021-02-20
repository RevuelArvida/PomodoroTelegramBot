package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.HelpCommand;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.StartCommand;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.StopCommand;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandName.*;

@Component
public class MessageCommandContainer implements Container {

    private final SendMessageService sendMessageService;
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public MessageCommandContainer(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))

                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    @Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }


}



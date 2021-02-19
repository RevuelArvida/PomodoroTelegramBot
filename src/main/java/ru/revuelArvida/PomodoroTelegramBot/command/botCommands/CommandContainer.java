package ru.revuelArvida.PomodoroTelegramBot.command.botCommands;


import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.command.*;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;
import static ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandName.*;

/**
 * Container of the {@link Command}'s for handling bot commands.
 *
 * @author RevuelArvida
 */
@Component
@Scope("singleton")
public class CommandContainer
{
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    @Autowired
    public CommandContainer(SendMessageService sendMessageService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))

                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }


    public Command retrieveCommand(String commandIdentifier){
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}

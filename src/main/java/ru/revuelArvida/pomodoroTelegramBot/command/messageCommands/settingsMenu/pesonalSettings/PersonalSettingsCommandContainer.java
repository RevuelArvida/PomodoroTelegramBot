package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import com.google.common.collect.ImmutableMap;

import org.springframework.stereotype.Component;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.Container;
import ru.revuelArvida.pomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.ExitCommand;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName.*;

@Component
public class PersonalSettingsCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final SendMessageService sendMessageService;
    private final Command unknownCommand;
    private final Checker checker;

    public PersonalSettingsCommandContainer(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;

        //todo INCORRECT VALUE TRY AGAIN COMMAND
        unknownCommand = new UnknownCommand(sendMessageService);
        checker = new Checker();

        commandMap = ImmutableMap.<String, Command>builder()
                .put(SET_WORK.getCommandName(), new SetWorkCommand(sendMessageService, checker))
                .put(SET_SHORT.getCommandName(), new SetShortCommand(sendMessageService, checker))
                .put(SET_LONG.getCommandName(), new SetLongCommand(sendMessageService,checker))
                .put(EXIT.getCommandName(), new ExitPersonalCommand(sendMessageService))
                .build();
    }



    @Override
    public Command retrieveCommand(String commandIdentifier, StateContext stateContext) {
        Command command;

            if (checker.getSetField() != null) {
                try {
                    int value = Integer.parseInt(commandIdentifier);
                    command = new SetFieldCommand(sendMessageService, value, checker, stateContext);
                } catch (NumberFormatException exc){
                    exc.printStackTrace();
                    command = unknownCommand;
                }
            } else {
                command = commandMap.getOrDefault(commandIdentifier, unknownCommand);

                if (command instanceof ExitCommand){
                    stateContext.setState(StateList.SLEEP);
                }
            }


        return command;
    }
}

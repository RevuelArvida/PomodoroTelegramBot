package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import com.google.common.collect.ImmutableMap;

import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.command.UnknownCommand;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.ExitCommand;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName.*;

@Component
public class PersonalSettingsCommandContainer implements Container {


    private final ImmutableMap<String, Command> commandMap;
    private final SendMessageService sendMessageService;
    private final Command unknownCommand;
    private final Checker checker;

    public PersonalSettingsCommandContainer(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
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

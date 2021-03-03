package ru.revuelArvida.pomodoroTelegramBot.bot.states;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.pomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandContainer;


@Component
public class PersonalSettingsState extends State {

    private final CommandContainer commandContainer;
    private final PersonalSettingsCommandContainer personalSettingsCommandContainer;

    public PersonalSettingsState(CommandContainersContainer container){
        this.commandContainer = container.getCommandContainer();
        this.personalSettingsCommandContainer = container.getPersonalSettingsCommandContainer();
    }

    @Override
    public void handleUpdate(Update update, StateContext stateContext) {
        if(update.hasMessage() && update.getMessage().hasText()){

            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {

                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);

            } else {

                String messageCommandIdentifier = message.toLowerCase();
                personalSettingsCommandContainer.retrieveCommand(messageCommandIdentifier, stateContext).execute(update);
            }


        }
    }
}

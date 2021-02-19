package ru.revuelArvida.PomodoroTelegramBot.bot.states;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuCommandContainer;

@Component
@Scope("singleton")
public class WaitState extends State {

    private final CommandContainer commandContainer;
    private final MainMenuCommandContainer mainMenuCommandContainer;

    @Autowired
    public WaitState(CommandContainersContainer container){
        this.commandContainer = container.getCommandContainer();
        this.mainMenuCommandContainer = container.getMainMenuCommandContainer();
    }


    @Override
    public void handleUpdate(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){

            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {

                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);

            } else {

                String messageCommandIdentifier = message.toLowerCase();
                mainMenuCommandContainer.retrieveCommand(messageCommandIdentifier).execute(update);
            }


        }
    }
}

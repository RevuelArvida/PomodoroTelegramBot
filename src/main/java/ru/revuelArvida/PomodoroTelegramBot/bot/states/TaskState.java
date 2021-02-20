package ru.revuelArvida.PomodoroTelegramBot.bot.states;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu.TasksMenuCommandContainer;

public class TaskState extends State{
    private final CommandContainer commandContainer;
    private final TasksMenuCommandContainer tasksMenuCommandContainer;

    @Autowired
    public TaskState(CommandContainersContainer container){
        this.commandContainer = container.getCommandContainer();
        this.tasksMenuCommandContainer = container.getTasksMenuCommandContainer();
    }


    @Override
    public void handleUpdate(Update update, StateContext stateContext) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {

                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);

            } else {

                String messageCommandIdentifier = message.toLowerCase();
                tasksMenuCommandContainer.retrieveCommand(messageCommandIdentifier, stateContext).execute(update);
            }


        }
    }
}

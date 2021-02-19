package ru.revuelArvida.PomodoroTelegramBot.command;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu.TasksMenuCommandContainer;

@Component
@Scope("singleton")
public class CommandContainersContainer {

    private final CommandContainer commandContainer;
    private final MainMenuCommandContainer mainMenuCommandContainer;
    private final SettingsMenuCommandContainer settingsMenuCommandContainer;
    private final TasksMenuCommandContainer tasksMenuCommandContainer;

    public CommandContainersContainer(
            CommandContainer commandContainer,
            MainMenuCommandContainer mainMenuCommandContainer,
            SettingsMenuCommandContainer settingsMenuCommandContainer,
            TasksMenuCommandContainer tasksMenuCommandContainer) {

        this.commandContainer = commandContainer;
        this.mainMenuCommandContainer = mainMenuCommandContainer;
        this.settingsMenuCommandContainer  = settingsMenuCommandContainer;
        this.tasksMenuCommandContainer = tasksMenuCommandContainer;


    }

    public CommandContainer getCommandContainer() {
        return commandContainer;
    }

    public MainMenuCommandContainer getMainMenuCommandContainer() {
        return mainMenuCommandContainer;
    }

    public SettingsMenuCommandContainer getSettingsMenuCommandContainer() {
        return settingsMenuCommandContainer;
    }

    public TasksMenuCommandContainer getTasksMenuCommandContainer() {
        return tasksMenuCommandContainer;
    }
}

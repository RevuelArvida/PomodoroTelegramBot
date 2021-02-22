package ru.revuelArvida.PomodoroTelegramBot.command;


import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu.TasksMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu.WorkMenuCommandContainer;

@Component
@Scope("singleton")
@Getter
public class CommandContainersContainer {

    private final CommandContainer commandContainer;
    private final MainMenuCommandContainer mainMenuCommandContainer;
    private final SettingsMenuCommandContainer settingsMenuCommandContainer;
    private final TasksMenuCommandContainer tasksMenuCommandContainer;
    private final WorkMenuCommandContainer workMenuCommandContainer;
    private final PersonalSettingsCommandContainer personalSettingsCommandContainer;



    public CommandContainersContainer(
            CommandContainer commandContainer,
            MainMenuCommandContainer mainMenuCommandContainer,
            SettingsMenuCommandContainer settingsMenuCommandContainer,
            TasksMenuCommandContainer tasksMenuCommandContainer,
            WorkMenuCommandContainer workMenuCommandContainer,
            PersonalSettingsCommandContainer personalSettingsCommandContainer) {

        this.commandContainer = commandContainer;
        this.mainMenuCommandContainer = mainMenuCommandContainer;
        this.settingsMenuCommandContainer  = settingsMenuCommandContainer;
        this.tasksMenuCommandContainer = tasksMenuCommandContainer;
        this.workMenuCommandContainer = workMenuCommandContainer;
        this.personalSettingsCommandContainer = personalSettingsCommandContainer;


    }

}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;


import org.springframework.context.annotation.Scope;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.SettingsState;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.State;

/**
 * List of message commands
 *
 * @author RevuelArvida
 */
public enum MainMenuMessageCommandName {
    WORK("начать работу"),
    SETTINGS("настройки"),
    TASKS("задачи");

    private final String commandName;

    MainMenuMessageCommandName(String commandName){
        this.commandName = commandName;
    }


    public String getCommandName()
    {return commandName;}
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu;


import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;

/**
 * List of message commands
 *
 * @author RevuelArvida
 */
public enum MainMenuMessageCommandName implements CommandName {
    WORK("начать работу"),
    SETTINGS("настройки"),
    TASKS("задачи"),
    STATISTICS("cтатистика");

    private final String commandName;

    MainMenuMessageCommandName(String commandName){
        this.commandName = commandName;
    }


    public String getCommandName()
    {return commandName;}
}

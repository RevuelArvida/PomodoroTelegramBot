package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;




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

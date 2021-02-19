package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

public enum SettingsCommandName {
    DEFAULT("установить настройки по умолчанию"),
    PERSONAL("установить свои настройки"),
    EXIT("выход");

    private final String commandName;

    SettingsCommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }


}

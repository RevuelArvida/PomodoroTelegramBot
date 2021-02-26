package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.CommandName;

public enum SettingsCommandName implements CommandName {
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

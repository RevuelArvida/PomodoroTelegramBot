package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.CommandName;

public enum PersonalSettingsCommandName implements CommandName {
    SET_WORK("длительность работы"),
    SET_SHORT("длительность короткого перерыва"),
    SET_LONG("длительность большого перерыва"),
    EXIT("выход");

    private String commandName;

    PersonalSettingsCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

public enum PersonalSettingsCommandName {
    SET_WORK("установить длительность работы"),
    SET_SHORT("установить длительность короткого перерыва"),
    SET_LONG("установить длительность большого перерыва"),
    EXIT("выход");

    private String commandName;

    PersonalSettingsCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}

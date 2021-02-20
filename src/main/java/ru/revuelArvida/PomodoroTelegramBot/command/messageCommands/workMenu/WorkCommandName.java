package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

public enum WorkCommandName {

    STARTWORK("начать работу"),
    STARTBREAK("начать перерыв"),
    PAUSE("пауза"),
    RESUME("продолжить работу"),
    STOP("прекратить работу");

    private final String commandName;

    WorkCommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}

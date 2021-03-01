package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;

public enum WorkCommandName implements CommandName {

    START_WORK("начать работу"),
    START_BREAK("начать перерыв"),
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

package ru.revuelArvida.pomodoroTelegramBot.command.botCommands;

/**
 * List of commands
 *
 * @author RevuelArvida
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }
}

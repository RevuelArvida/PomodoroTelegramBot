package ru.revuelArvida.PomodoroTelegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for handling bot commands.
 *
 * @author RevuelArvida
 */
public interface Command {

    /**
     * Main method, which is executing command logic.
     * @param update provided {@link Update} object with all the needed data for command execution.
     */
    void execute(Update update);

}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.PomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.StartWorkCommand.*;
import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.WORK;

public class StartWorkCommandTest extends AbstractCommandTest {

    StartWorkCommand startWorkCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        startWorkCommand = new StartWorkCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return WORK.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START_WORK;
    }

    @Override
    protected Command getCommand() {
        return startWorkCommand;
    }
}

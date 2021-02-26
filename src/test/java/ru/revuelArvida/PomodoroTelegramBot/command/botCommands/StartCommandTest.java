package ru.revuelArvida.PomodoroTelegramBot.command.botCommands;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.PomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;



import static ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandName.START;
import static ru.revuelArvida.PomodoroTelegramBot.command.botCommands.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstractCommandTest {

    StartCommand startCommand;

    @BeforeEach
    @Override
    public void initCommand(){
        startCommand = new StartCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return START.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return startCommand;
    }
}

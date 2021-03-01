package ru.revuelArvida.pomodoroTelegramBot.command.botCommands;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;



import static ru.revuelArvida.pomodoroTelegramBot.command.botCommands.CommandName.START;
import static ru.revuelArvida.pomodoroTelegramBot.command.botCommands.StartCommand.START_MESSAGE;

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

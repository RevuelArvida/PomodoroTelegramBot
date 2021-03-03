package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.StopCommand.STOP_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.STOP;

public class StopCommandTest extends AbstractCommandTest {

    StopCommand stopCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        stopCommand = new StopCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return stopCommand;
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.ChangeCommand.CHANGE_COMMAND_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName.CHANGE;

public class ChangeCommandTest extends AbstractCommandTest {

    ChangeCommand changeCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        changeCommand = new ChangeCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return CHANGE.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return CHANGE_COMMAND_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return changeCommand;
    }

    @Test
    @SneakyThrows
    @Override
    public void executeTest_whenEverythingIsOk_thenExecuteCommand(){
        //given
        //when
        getCommand().execute(update);
        //then;
        Mockito.verify(sendMessageService).sendMessage(
                ArgumentMatchers.any(),
                ArgumentMatchers.eq(getCommandMessage()));
    }
}

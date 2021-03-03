package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.DeleteCommand.DELETE_COMMAND_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName.DELETE;

public class DeleteCommandTest extends AbstractCommandTest {

    DeleteCommand deleteCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        deleteCommand = new DeleteCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return DELETE.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return DELETE_COMMAND_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return deleteCommand;
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

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.AddByIndexCommand.ADD_COMMAND_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName.ADD_AT_INDEX;

public class AddByIndexCommandTest extends AbstractCommandTest {

    AddByIndexCommand addByIndexCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        addByIndexCommand = new AddByIndexCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return ADD_AT_INDEX.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return ADD_COMMAND_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return addByIndexCommand;
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

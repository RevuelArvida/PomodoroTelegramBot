package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.AddCommand.ADD_COMMAND_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName.ADD;

public class AddCommandTest extends AbstractCommandTest {

    AddCommand addCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        addCommand = new AddCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return ADD.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return ADD_COMMAND_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return addCommand;
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

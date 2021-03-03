package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.StartWorkCommand.START_WORK_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.START_WORK;

public class StartWorkCommandTest extends AbstractCommandTest {

    StartWorkCommand startWorkCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        startWorkCommand = new StartWorkCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return START_WORK.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START_WORK_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return startWorkCommand;
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

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.StartBreakCommand.START_BREAK_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.START_BREAK;

public class StartBreakCommandTest extends AbstractCommandTest {

    StartBreakCommand startBreakCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
       startBreakCommand = new StartBreakCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return START_BREAK.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return START_BREAK_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return startBreakCommand;
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

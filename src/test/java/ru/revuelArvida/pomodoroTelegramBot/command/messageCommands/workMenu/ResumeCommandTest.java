package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.ResumeCommand.RESUME_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.RESUME;

public class ResumeCommandTest extends AbstractCommandTest {

    ResumeCommand resumeCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        resumeCommand = new ResumeCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return RESUME.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return RESUME_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return resumeCommand;
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

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SchedulerService;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.StartBreakCommand.START_BREAK_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName.START_BREAK;

public class StartBreakCommandTest extends AbstractCommandTest {

    StartBreakCommand startBreakCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        SchedulerService schedulerService = Mockito.mock(SchedulerService.class);
       startBreakCommand = new StartBreakCommand(sendMessageService, schedulerService);
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
        Mockito.verify(sendMessageService).sendMessageWithKeyboard(
                ArgumentMatchers.any(),
                ArgumentMatchers.eq(getCommandMessage()),
                ArgumentMatchers.any(ReplyKeyboardMarkup.class));
    }
}

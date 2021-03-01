package ru.revuelArvida.pomodoroTelegramBot.command.botCommands;


import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.botCommands.HelpCommand.HELP_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.botCommands.CommandName.HELP;

public class HelpCommandTest extends AbstractCommandTest {

    HelpCommand helpCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        helpCommand = new HelpCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return helpCommand;
    }

    @Override
    @SneakyThrows
    @Test
    public void executeTest_whenEverythingIsOk_thenExecuteCommand(){
        //given
        //when
        getCommand().execute(update);
        //then;
        Mockito.verify(sendMessageService).sendMessage(
                ArgumentMatchers.any(),
                ArgumentMatchers.any());
    }


}

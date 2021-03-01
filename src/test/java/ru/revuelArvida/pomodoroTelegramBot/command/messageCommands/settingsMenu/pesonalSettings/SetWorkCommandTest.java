package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;

import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName.SET_WORK;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.SetWorkCommand.SET_WORK_MESSAGE;
public class SetWorkCommandTest extends AbstractCommandTest {

    SetWorkCommand setWorkCommand;
    Checker checker;

    @BeforeEach
    @Override
    protected void initCommand() {
        checker = Mockito.mock(Checker.class);
        setWorkCommand = new SetWorkCommand(sendMessageService, checker);
    }

    @Override
    protected String getCommandName() {
        return SET_WORK.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return SET_WORK_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return setWorkCommand;
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
        Mockito.verify(checker).setSetField(ArgumentMatchers.eq(Checker.SetField.WORK));
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.SetShortCommand.SET_SHORT_MESSAGE;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName.SET_SHORT;

public class SetShortCommandTest extends AbstractCommandTest {

    SetShortCommand setShortCommand;
    Checker checker;

    @BeforeEach
    @Override
    protected void initCommand() {
        checker = Mockito.mock(Checker.class);
        setShortCommand = new SetShortCommand(sendMessageService, checker);
    }

    @Override
    protected String getCommandName() {
        return SET_SHORT.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return SET_SHORT_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return setShortCommand;
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
        Mockito.verify(checker).setSetField(ArgumentMatchers.eq(Checker.SetField.SHORT));
    }
}

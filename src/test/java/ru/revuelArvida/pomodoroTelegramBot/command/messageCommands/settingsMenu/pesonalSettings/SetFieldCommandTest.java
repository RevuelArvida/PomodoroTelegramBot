package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.SetFieldCommand.*;



public class SetFieldCommandTest extends AbstractCommandTest {
    //to do ALL
    SetFieldCommand setFieldCommand;
    Checker checker;
    StateContext stateContext;

    @BeforeEach
    @Override
    protected void initCommand() {
        int value = 15;
        checker = Mockito.mock(Checker.class);
        stateContext = Mockito.mock(StateContext.class);

        setFieldCommand = new SetFieldCommand(sendMessageService, value, checker, stateContext);
    }

    @Override
    protected String getCommandName() {
        return null;
    }

    @Override
    protected String getCommandMessage() {
        return null;
    }

    @Override
    protected Command getCommand() {
        return setFieldCommand;
    }


    /**
     * If everything ok, then setValue to work Field;
     */
    @Test
    @Override
    public void executeTest_whenEverythingIsOk_thenExecuteCommand(){
        //given
        Mockito.when(checker.getSetField()).thenReturn(Checker.SetField.WORK);
        //when
        getCommand().execute(update);
        //then
        Mockito.verify(sendMessageService).sendMessage(
                ArgumentMatchers.any(),
                ArgumentMatchers.any());
        Mockito.verify(checker).setIsWorkSet(true);
        Mockito.verify(checker).setSetField(ArgumentMatchers.isNull());
    }

    @Test
    public void executeTest_whenValueIsInvalid_thenSendIncorrectValueMessage(){
        //given
        int value = 255;
        setFieldCommand = new SetFieldCommand(sendMessageService, 255, checker, stateContext);
        //when
        setFieldCommand.execute(update);
        //then
        Mockito.verify(sendMessageService).sendMessage(
                ArgumentMatchers.any(),
                ArgumentMatchers.matches(INCORRECT_VALUE));
    }

    @Test
    public void executeTest_whenEveryThingIsSetUp_thenChangeStateAndSendAllSetUpMessage(){
        //given
        Mockito.when(checker.getIsLongBreakSet()).thenReturn(true);
        Mockito.when(checker.getIsWorkSet()).thenReturn(true);
        Mockito.when(checker.getIsShortBrakeSet()).thenReturn(true);
        Mockito.when(checker.getSetField()).thenReturn(Checker.SetField.LONG);
        //when
        getCommand().execute(update);
        //then
        Mockito.verify(sendMessageService).sendMessageWithKeyboard(ArgumentMatchers.any(),
                ArgumentMatchers.matches(ALL_SET_UP),
                ArgumentMatchers.any(ReplyKeyboardMarkup.class));
        Mockito.verify(checker).setSetField(ArgumentMatchers.isNull());
        Mockito.verify(stateContext).setState(ArgumentMatchers.eq(StateList.SLEEP));
    }

}

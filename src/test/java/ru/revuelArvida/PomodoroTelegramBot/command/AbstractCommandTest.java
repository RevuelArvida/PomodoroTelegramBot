package ru.revuelArvida.PomodoroTelegramBot.command;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageBotService;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

public abstract class AbstractCommandTest {

    protected SendMessageService sendMessageService;
    protected Update update;
    protected Message message;
    protected SendMessage sendMessage;
    protected PomodoroBot pomodoroBot;

    @BeforeEach
    protected abstract void initCommand();

    protected abstract String getCommandName();
    protected abstract String getCommandMessage();
    protected abstract Command getCommand();



    @BeforeEach
    public void init(){

        sendMessageService = Mockito.mock(SendMessageBotService.class);
        update = Mockito.mock(Update.class);
        pomodoroBot = Mockito.mock(PomodoroBot.class);
        message = Mockito.mock(Message.class);
        sendMessage = Mockito.mock(SendMessage.class);


        Mockito.when(update.getMessage()).thenReturn(message);
    }

    @Test
    @SneakyThrows
    public void executeTest_whenEverythingIsOk_thenExecuteCommand(){
        //given
        //when
        getCommand().execute(update);
        //then;
        Mockito.verify(sendMessageService).sendMessageWithKeyboard(
                ArgumentMatchers.any(),
                ArgumentMatchers.any(),
                ArgumentMatchers.any());
    }

}

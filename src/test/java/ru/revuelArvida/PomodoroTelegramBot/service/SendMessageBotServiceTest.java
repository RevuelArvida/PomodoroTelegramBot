package ru.revuelArvida.PomodoroTelegramBot.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;


public class SendMessageBotServiceTest {

    private SendMessageBotService sendMessageBotService;
    private PomodoroBot pomodoroBot;

    @BeforeEach
    public void init(){
        pomodoroBot = Mockito.mock(PomodoroBot.class);
        sendMessageBotService = new SendMessageBotService(pomodoroBot);
    }

    @Test
    @SneakyThrows
    public void sendMessageTest_whenEverythingIsOk_thenSendMessage() {
        //given
        String chatId = "ChatId";
        String message = "message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);

        //when
        sendMessageBotService.sendMessage(chatId, message);

        //then
        Mockito.verify(pomodoroBot).execute(sendMessage);
    }

    @Test
    @SneakyThrows
    public void sendMessageWithKeyboardTest_whenEverythingIsOk_thenSendMessage(){
        //given
       ReplyKeyboardMarkup keyboardMarkup =  Mockito.mock(ReplyKeyboardMarkup.class);

        String chatId = "ChatId";
        String message = "message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(keyboardMarkup);

        //when
        sendMessageBotService.sendMessageWithKeyboard(chatId, message, keyboardMarkup);

        //then
        Mockito.verify(pomodoroBot).execute(sendMessage);


    }

    @Test
    public void sendMessageTest_whenSomethingWrong_thenThrowException(){
        //given
        String chatId = "";
        String message = "";



        // when
        sendMessageBotService.sendMessage(chatId, message);

        // then
        Assertions.assertThrows(Exception.class,
                ()-> sendMessageBotService.sendMessage(ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString()));
    }

    @Test
    public void sendMessageWithKeyboardTest_whenSomethingWrong_thenThrowException(){
        //given
        String chatId = "";
        String message = "";
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        // when
        sendMessageBotService.sendMessageWithKeyboard(chatId, message, keyboardMarkup);

        // then
        Assertions.assertThrows(Exception.class,
                ()-> sendMessageBotService.sendMessageWithKeyboard(ArgumentMatchers.anyString(),
                        ArgumentMatchers.anyString(), ArgumentMatchers.any()));
    }


}

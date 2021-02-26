package ru.revuelArvida.PomodoroTelegramBot.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;

/**
 * Implementation of {@link SendMessageService}.
 *
 * @author RevuelArvida
 */

@Component
@Scope("singleton")
public class SendMessageBotService implements SendMessageService {



    private final PomodoroBot bot;

    public SendMessageBotService(@Lazy PomodoroBot bot){
        this.bot = bot;
    }


    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        sendMessage(sendMessage);
    }

    @Override
    public void sendMessageWithKeyboard(String chatId, String message,
                             ReplyKeyboardMarkup replyKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        sendMessage(sendMessage);
    }


    private void sendMessage(SendMessage sendMessage){
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException exc){
            //todo add logging to the project
            exc.printStackTrace();
        }
    }
}

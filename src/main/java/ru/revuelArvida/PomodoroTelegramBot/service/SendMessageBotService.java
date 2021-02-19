package ru.revuelArvida.PomodoroTelegramBot.service;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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

    public SendMessageBotService(PomodoroBot bot){
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException exc){
            //todo add logging to the project
            exc.printStackTrace();
        }


    }
}

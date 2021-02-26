package ru.revuelArvida.PomodoroTelegramBot.service;


import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

/**
 * Service for sending messages via telegram-bot
 * @author RevuelArvida
 */
public interface SendMessageService {

    /**
     * Send message via telegram-bot.
     *  @param chatId provides the destination of the message.
     * @param message provides body of the message.
     * @return
     */
    void sendMessage(String chatId, String message);
    void sendMessageWithKeyboard(String chatId, String message, ReplyKeyboardMarkup replyKeyboardMarkup);
}

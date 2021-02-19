package ru.revuelArvida.PomodoroTelegramBot.service;


/**
 * Service for sending messages via telegram-bot
 * @author RevuelArvida
 */
public interface SendMessageService {

    /**
     * Send message via telegram-bot.
     *
     * @param chatId provides the destination of the message.
     * @param message provides body of the message.
     */
    public void sendMessage(String chatId, String message);
}

package ru.revuelArvida.pomodoroTelegramBot.service;


import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.Timer;
import java.util.TimerTask;

@Component
@Scope("prototype")
public class SchedulerService {

    SendMessageService sendMessageService;
    Timer timer;


    
    public SchedulerService(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
        timer = new Timer();
    }

    public void startTimer(String chatId, String message,TimerType timerType,
                           ReplyKeyboardMarkup replyKeyboardMarkup){
        TimerTask task = getTask(chatId, message, replyKeyboardMarkup);

            //todo CustomTimer
            //Test timer
            timer.schedule(task, 1 * 60000);
    }

    private TimerTask getTask(String chatId, String message,
                              ReplyKeyboardMarkup replyKeyboardMarkup){
        return new TimerTask() {
            @Override
            public void run() {
                sendMessageService.sendMessageWithKeyboard(chatId, message, replyKeyboardMarkup);
            }
        };
    }
    
    public void stopTimer(){
        timer.cancel();
        timer = new Timer();
    }
    
    


}

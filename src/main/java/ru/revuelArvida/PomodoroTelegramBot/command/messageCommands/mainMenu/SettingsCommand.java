package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;


/**
 * Implementation of {@link Command} interface for Settings {@link MainMenuMessageCommandName}
 *
 * @author RevuelArvida
 */
@Component
class SettingsCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String SETTINGS_MESSAGE = "Вы перешли в меню найстроек!";

    public SettingsCommand (SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }



    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), SETTINGS_MESSAGE);
    }
}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;


class PersonalCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String PERSONAL_SETTINGS_MESSAGE = "Перехожу в режим персонализации";

    public PersonalCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), PERSONAL_SETTINGS_MESSAGE);
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

class SetShortCommand implements Command {

    private final SendMessageService sendMessageService;
    private final Checker checker;

    public static final String SET_SHORT_MESSAGE = "Введите длительность короткого перерыва минутах";


    public SetShortCommand(SendMessageService sendMessageService, Checker checker){
        this.sendMessageService = sendMessageService;
        this.checker = checker;
    }
    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), SET_SHORT_MESSAGE);
        checker.setSetField(Checker.SetField.SHORT);
    }
}

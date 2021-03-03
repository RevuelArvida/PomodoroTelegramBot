package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

class SetLongCommand implements Command {

    private final SendMessageService sendMessageService;
    private final Checker checker;

    public static final String SET_LONG_MESSAGE = "Введите длительность большого перерыва в минутах";


    public SetLongCommand(SendMessageService sendMessageService, Checker checker){
        this.sendMessageService = sendMessageService;
        this.checker = checker;
    }
    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), SET_LONG_MESSAGE);
        checker.setSetField(Checker.SetField.LONG);
    }
}

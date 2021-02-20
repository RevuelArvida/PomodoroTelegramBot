package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class SetLongCommand implements Command {

    private final SendMessageService sendMessageService;
    private final Checker checker;

    private final String SET_WORK_MESSAGE = "Введите длительность большого перерыва в минутах";


    public SetLongCommand(SendMessageService sendMessageService, Checker checker){
        this.sendMessageService = sendMessageService;
        this.checker = checker;
    }
    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), SET_WORK_MESSAGE);
        checker.setSetField(Checker.SetField.LONG);
    }
}

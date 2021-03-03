package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SchedulerService;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;

class PauseCommand implements Command {

    private final SendMessageService sendMessageService;
    private final SchedulerService schedulerService;
    public static final String PAUSE_MESSAGE = "Пауза";

    public PauseCommand(SendMessageService sendMessageService, SchedulerService schedulerService){
        this.sendMessageService = sendMessageService;
        this.schedulerService = schedulerService;
    }


    @Override
    public void execute(Update update) {
        CommandName[] commands = {WorkCommandName.RESUME, WorkCommandName.STOP};
        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }

        schedulerService.stopTimer();

        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();
        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                PAUSE_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}
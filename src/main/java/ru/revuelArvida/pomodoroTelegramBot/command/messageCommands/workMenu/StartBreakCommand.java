package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SchedulerService;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;
import ru.revuelArvida.pomodoroTelegramBot.service.TimerType;

import java.util.ArrayList;
import java.util.List;

class StartBreakCommand implements Command {

    private final SendMessageService sendMessageService;
    private final SchedulerService schedulerService;
    public static final String START_BREAK_MESSAGE = "Отдыхаем";
    public static final String END_BREAK_MESSAGE = "Отдых закончен";

    public StartBreakCommand(SendMessageService sendMessageService, SchedulerService schedulerService){
        this.sendMessageService = sendMessageService;
        this.schedulerService = schedulerService;
    }


    @Override
    public void execute(Update update) {
        CommandName[] commands = {WorkCommandName.STOP};

        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }

        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();

        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                START_BREAK_MESSAGE, builder.getKeyboardMarkup(commandList));

        CommandName[] commands2 = {WorkCommandName.START_WORK, WorkCommandName.STOP};

        commandList = new ArrayList<>();
        for (CommandName command: commands2){
            commandList.add(command.getCommandName());
        }


        schedulerService.startTimer(update.getMessage().getChatId().toString(),
                END_BREAK_MESSAGE, TimerType.SHORT_BREAK, builder.getKeyboardMarkup(commandList));
    }
}
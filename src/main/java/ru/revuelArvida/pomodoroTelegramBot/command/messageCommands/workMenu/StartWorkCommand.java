package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SchedulerService;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;
import ru.revuelArvida.pomodoroTelegramBot.service.TimerType;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


class StartWorkCommand implements Command {

    private final SendMessageService sendMessageService;
    private SchedulerService schedulerService;
    public static final String START_WORK_MESSAGE = "Приступаем к работе";
    public static final String END_WORK_MESSAGE = "Пора сделать перерыв";

    public StartWorkCommand(SendMessageService sendMessageService, SchedulerService schedulerService){
        this.sendMessageService = sendMessageService;
        this.schedulerService = schedulerService;
    }



    @Override
    public void execute(Update update) {
        CommandName[] commands = {WorkCommandName.PAUSE, WorkCommandName.STOP};

        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }
        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();

        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                START_WORK_MESSAGE, builder.getKeyboardMarkup(commandList));

        CommandName[] commands2 = {WorkCommandName.START_BREAK, WorkCommandName.STOP};

        List<String> commandList2 = new ArrayList<>();
        for (CommandName command: commands2){
            commandList2.add(command.getCommandName());
        }

        schedulerService.startTimer(update.getMessage().getChatId().toString(), END_WORK_MESSAGE,
                TimerType.WORK, builder.getKeyboardMarkup(commandList2));
    }
}

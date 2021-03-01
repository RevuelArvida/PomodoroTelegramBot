package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.tasksMenu.TaskCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Command} interface for TASK {@link Command}
 *
 * @author RevuelArvida
 */
class TasksCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String TASK_MESSAGE = "Вы перешли в меню задач!";

    public TasksCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        CommandName[] commands = TaskCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }
        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();


        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                TASK_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}

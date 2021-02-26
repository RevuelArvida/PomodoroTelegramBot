package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of {@link Command} interface for WORK {@link Command}
 *
 * @author RevuelArvida
 */
class StartWorkCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String START_WORK = "Вы запустили таймер и перешли в меню управления " +
            "таймером!";

    public StartWorkCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        CommandName[] commands = WorkCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }
        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();


        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                START_WORK, builder.getKeyboardMarkup(commandList));
    }
}

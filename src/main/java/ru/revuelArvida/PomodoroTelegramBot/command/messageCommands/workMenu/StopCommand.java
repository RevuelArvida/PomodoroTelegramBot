package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.workMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;

class StopCommand implements Command {

    private final SendMessageService sendMessageService;
    public final static String STOP_MESSAGE = "Прекращаем работу, возвращаемся в главное меню";

    public StopCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        CommandName[] commands = MainMenuMessageCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }
        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();

        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                STOP_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;


public class ExitCommand implements Command {



    private final SendMessageService sendMessageService;
    private final String EXIT_MESSAGE = "Возвращаемся в главное меню";

    public ExitCommand(SendMessageService sendMessageService){
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
                EXIT_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.botCommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link Command} interface for START {@link CommandName}
 *
 * @author RevuelArvida
 */

class StartCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String START_MESSAGE = "Привет, я - твой личный тайм менеджер, сообщу " +
            "тебе когда ты в помидоре, а когда следует отдохнуть!";

    @Autowired
    public StartCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }


    @Override
    public void execute(Update update) {
        MainMenuMessageCommandName[] commands = MainMenuMessageCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (MainMenuMessageCommandName command: commands){
            commandList.add(command.getCommandName());
        }

        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();

        sendMessageService.sendMessageWithKeyboard(
                update.getMessage().getChatId().toString(),
                START_MESSAGE,
                builder.getKeyboardMarkup(commandList));

    }

}

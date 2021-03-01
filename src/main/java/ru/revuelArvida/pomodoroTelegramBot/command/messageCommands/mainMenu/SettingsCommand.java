package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of {@link Command} interface for Settings {@link MainMenuMessageCommandName}
 *
 * @author RevuelArvida
 */
@Component
class SettingsCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String SETTINGS_MESSAGE = "Вы перешли в меню найстроек!";

    public SettingsCommand (SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }



    @Override
    public void execute(Update update) {
        SettingsCommandName[] commands = SettingsCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (SettingsCommandName command: commands){
            commandList.add(command.getCommandName());
        }

        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();



        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                SETTINGS_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}

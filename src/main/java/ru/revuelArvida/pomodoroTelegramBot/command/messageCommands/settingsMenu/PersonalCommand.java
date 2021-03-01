package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;


class PersonalCommand implements Command {

    private final SendMessageService sendMessageService;

    public final static String PERSONAL_SETTINGS_MESSAGE = "Перехожу в режим персонализации, для " +
            "возврата в главное меню установите все значения";

    public PersonalCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        CommandName[] commands = PersonalSettingsCommandName.values();
        List<String> commandList = new ArrayList<>();
        for (CommandName command: commands){
            commandList.add(command.getCommandName());
        }
        KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();

        sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                PERSONAL_SETTINGS_MESSAGE, builder.getKeyboardMarkup(commandList));
    }
}

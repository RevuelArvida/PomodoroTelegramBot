package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.State;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.WaitState;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

class DefaultCommand implements Command {

    private State state;

    private final SendMessageService sendMessageService;
    public final static String DEFAULT_SETTINGS_MESSAGE = "Устанавливаем настройки по умолчанию";

    public DefaultCommand(SendMessageService sendMessageService){
        this.sendMessageService = sendMessageService;
    }

    @PostConstruct
    public void init(CommandContainersContainer container){
        this.state = new WaitState(container);
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
                DEFAULT_SETTINGS_MESSAGE, builder.getKeyboardMarkup(commandList));
    }

}

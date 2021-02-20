package ru.revuelArvida.PomodoroTelegramBot.bot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.*;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.botCommands.CommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageBotService;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

/**
 * Telegram bot for Time Management
 * @author RevuelArvida
 */

@Component
@PropertySource("datasource.properties")
public class PomodoroBot extends TelegramLongPollingBot {

    private final StateContext stateContext;

    @Value("${bot.botName}")
    private String botUsername;
    @Value("${bot.botToken}")
    private String botToken;




    public PomodoroBot(){
        SendMessageService sendMessageService = new SendMessageBotService(this);
        CommandContainersContainer commandContainersContainer = new CommandContainersContainer(
                new CommandContainer(sendMessageService),
                new MainMenuCommandContainer(sendMessageService));

        this.stateContext = new StateContext(commandContainersContainer);
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


    @Override
    public void onUpdateReceived(Update update) {
        stateContext.handleUpdate(update);
    }

}

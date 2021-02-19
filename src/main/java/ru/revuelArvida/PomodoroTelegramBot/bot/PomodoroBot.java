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
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu.TasksMenuCommandContainer;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageBotService;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

/**
 * Telegram bot for Time Management
 * @author RevuelArvida
 */

@Component
@PropertySource("datasource.properties")
public class PomodoroBot extends TelegramLongPollingBot {

    private State state;
    private SuperState superState;
    private CommandContainersContainer commandContainersContainer;

    @Value("${bot.botName}")
    private String botUsername;
    @Value("${bot.botToken}")
    private String botToken;



    public PomodoroBot(){
        SendMessageService sendMessageService = new SendMessageBotService(this);
        commandContainersContainer = new CommandContainersContainer(
                new CommandContainer(sendMessageService),
                new MainMenuCommandContainer(sendMessageService, this),
                new SettingsMenuCommandContainer(sendMessageService, this),
                new TasksMenuCommandContainer(sendMessageService, this)
        );

        superState = new SuperState(new WaitState(commandContainersContainer),
                new SettingsState(commandContainersContainer),
                        new PersonalSettingsState(commandContainersContainer));


        this.state = superState.getWaitState();
    }

    public SuperState getSuperState(){
        return superState;
    }

    public void changeState(State state){
        this.state = state;
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
        state.handleUpdate(update);
    }

}

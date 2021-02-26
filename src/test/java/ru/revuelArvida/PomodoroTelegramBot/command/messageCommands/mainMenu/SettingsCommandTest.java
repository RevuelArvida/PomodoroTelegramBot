package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.PomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.SettingsCommand.*;
import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.SETTINGS;


public class SettingsCommandTest extends AbstractCommandTest {

    Command settingsCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        settingsCommand = new SettingsCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return SETTINGS.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return SETTINGS_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return settingsCommand;
    }
}

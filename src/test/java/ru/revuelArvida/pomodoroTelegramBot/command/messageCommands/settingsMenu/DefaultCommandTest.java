package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.DefaultCommand.*;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsCommandName.DEFAULT;

public class DefaultCommandTest extends AbstractCommandTest {

   DefaultCommand defaultCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        defaultCommand = new DefaultCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return DEFAULT.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return DEFAULT_SETTINGS_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return defaultCommand;
    }

}

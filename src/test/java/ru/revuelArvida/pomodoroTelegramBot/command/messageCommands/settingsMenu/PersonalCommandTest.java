package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.PersonalCommand.*;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.SettingsCommandName.PERSONAL;

public class PersonalCommandTest extends AbstractCommandTest {

    PersonalCommand personalCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        personalCommand = new PersonalCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return PERSONAL.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return PERSONAL_SETTINGS_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return personalCommand;
    }
}

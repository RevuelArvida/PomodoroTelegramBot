package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.pomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.ExitPersonalCommand.EXIT_PERSONAL;
import static ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings.PersonalSettingsCommandName.EXIT;

public class ExitPersonalCommandTest extends AbstractCommandTest {

    ExitPersonalCommand exitPersonalCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        exitPersonalCommand = new ExitPersonalCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return EXIT.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return EXIT_PERSONAL;
    }

    @Override
    protected Command getCommand() {
        return exitPersonalCommand;
    }
}

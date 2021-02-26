package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu;
import org.junit.jupiter.api.BeforeEach;
import ru.revuelArvida.PomodoroTelegramBot.command.AbstractCommandTest;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;

import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.TasksCommand.TASK_MESSAGE;
import static ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName.TASKS;

public class TaskCommandTest extends AbstractCommandTest {

    TasksCommand tasksCommand;

    @BeforeEach
    @Override
    protected void initCommand() {
        tasksCommand = new TasksCommand(sendMessageService);
    }

    @Override
    protected String getCommandName() {
        return TASKS.getCommandName();
    }

    @Override
    protected String getCommandMessage() {
        return TASK_MESSAGE;
    }

    @Override
    protected Command getCommand() {
        return tasksCommand;
    }
}

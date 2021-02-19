package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu;

import org.springframework.stereotype.Component;
import ru.revuelArvida.PomodoroTelegramBot.bot.PomodoroBot;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.command.Container;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

@Component
public class TasksMenuCommandContainer implements Container {



    public TasksMenuCommandContainer(SendMessageService sendMessageService, PomodoroBot bot){}

    @Override
    public Command retrieveCommand(String commandIdentifier) {
        return null;
    }
}

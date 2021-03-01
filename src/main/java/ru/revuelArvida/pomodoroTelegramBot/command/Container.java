package ru.revuelArvida.pomodoroTelegramBot.command;

import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;

public interface Container {

    Command retrieveCommand(String commandIdentifier, StateContext stateContext);

}

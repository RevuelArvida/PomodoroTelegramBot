package ru.revuelArvida.PomodoroTelegramBot.command;

import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;

public interface Container {

    Command retrieveCommand(String commandIdentifier, StateContext stateContext);

}

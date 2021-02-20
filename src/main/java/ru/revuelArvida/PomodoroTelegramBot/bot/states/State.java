package ru.revuelArvida.PomodoroTelegramBot.bot.states;


import org.telegram.telegrambots.meta.api.objects.Update;


public abstract class State {

    protected static String COMMAND_PREFIX = "/";

    public abstract void handleUpdate(Update update, StateContext stateContext);


}

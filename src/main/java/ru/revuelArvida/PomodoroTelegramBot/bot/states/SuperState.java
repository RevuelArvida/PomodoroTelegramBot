package ru.revuelArvida.PomodoroTelegramBot.bot.states;

public class SuperState {

    private final State waitState;
    private final State settingsState;
    private final State personalSettingsState;

    public SuperState(State waitState, State settingsState, State personalSettingsState) {
        this.waitState = waitState;
        this.settingsState = settingsState;
        this.personalSettingsState = personalSettingsState;
    }


    public State getWaitState() {
        return waitState;
    }

    public State getSettingsState() {
        return settingsState;
    }

    public State getPersonalSettingsState() {
        return personalSettingsState;
    }
}

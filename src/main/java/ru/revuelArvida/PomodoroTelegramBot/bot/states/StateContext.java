package ru.revuelArvida.PomodoroTelegramBot.bot.states;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.command.CommandContainersContainer;


@Component
public class StateContext {


    @Setter
    @Getter
    private StateList state;
    private final ImmutableMap<StateList, State> stateMap;


    @Autowired
    public StateContext(CommandContainersContainer container){
        state = StateList.SLEEP;

        stateMap = ImmutableMap.<StateList, State>builder()
                .put(StateList.SLEEP, new WaitState(container) )
                .put(StateList.SETTINGS, new SettingsState(container))
                .put(StateList.PERSONAL_SETTINGS, new PersonalSettingsState(container))
                .put(StateList.TASK, new TaskState(container))
                .put(StateList.WORK, new WorkState(container))
                .build();
    }

    public void handleUpdate(Update update){
        stateMap.get(state).handleUpdate(update, this);
    }



}

package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.PomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.PomodoroTelegramBot.command.Command;
import ru.revuelArvida.PomodoroTelegramBot.service.SendMessageService;

class SetFieldCommand implements Command {

    private final SendMessageService sendMessageService;
    private final Checker checker;
    private final int value;
    private final StateContext stateContext;
    private final String INCORRECT_VALUE = "Введенное число должно быть в диапазоне от 1 до 30";
    private final String ALL_SET_UP = "Все настройки установлены, возвращаюсь в главное меню";

    public SetFieldCommand (SendMessageService sendMessageService, int value, Checker checker,
                            StateContext stateContext){
        this.sendMessageService = sendMessageService;
        this.value = value;
        this.checker = checker;
        this.stateContext = stateContext;
    }


    @Override
    public void execute(Update update) {
        if (value <= 0 || value > 30 ){
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), INCORRECT_VALUE);
        } else {
            //todo setValue Logic

            sendMessageService.sendMessage(update.getMessage().getChatId().toString(),
                    checker.getSetField().getFieldName() + " установлена");

            if (checker.getSetField() == Checker.SetField.WORK){
                checker.setIsWorkSet(true);
                //todo sent kb shortbrake
            } else if (checker.getSetField() == Checker.SetField.SHORT){
                checker.setIsShortBrakeSet(true);
                //todo sent kb longbrake
            } else if (checker.getSetField() == Checker.SetField.LONG) {
                checker.setIsLongBreakSet(true);
            }

            if (checker.getIsLongBreakSet() & checker.getIsWorkSet() & checker.getIsShortBrakeSet()){
                sendMessageService.sendMessage(update.getMessage().getChatId().toString(), ALL_SET_UP);
                checker.setSetField(null);
                stateContext.setState(StateList.SLEEP);
            }

            checker.setSetField(null);
        }
    }
}

package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateContext;
import ru.revuelArvida.pomodoroTelegramBot.bot.states.StateList;
import ru.revuelArvida.pomodoroTelegramBot.command.Command;
import ru.revuelArvida.pomodoroTelegramBot.command.KeyboardMarkupBuilder;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.CommandName;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.mainMenu.MainMenuMessageCommandName;
import ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.workMenu.WorkCommandName;
import ru.revuelArvida.pomodoroTelegramBot.service.SendMessageService;

import java.util.ArrayList;
import java.util.List;

class SetFieldCommand implements Command {

    private final SendMessageService sendMessageService;
    private final Checker checker;
    private final int value;
    private final StateContext stateContext;
    public final static String INCORRECT_VALUE = "Введенное число должно быть в диапазоне от 1 до 30";
    public final static String ALL_SET_UP = "Все настройки установлены, возвращаюсь в главное меню";

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
            } else if (checker.getSetField() == Checker.SetField.SHORT){
                checker.setIsShortBrakeSet(true);
            } else if (checker.getSetField() == Checker.SetField.LONG) {
                checker.setIsLongBreakSet(true);
            }

            if (checker.getIsLongBreakSet() & checker.getIsWorkSet() & checker.getIsShortBrakeSet()){
                CommandName[] commands = MainMenuMessageCommandName.values();

                List<String> commandList = new ArrayList<>();
                for (CommandName command: commands){
                    commandList.add(command.getCommandName());
                }
                KeyboardMarkupBuilder builder = new KeyboardMarkupBuilder();


                sendMessageService.sendMessageWithKeyboard(update.getMessage().getChatId().toString(),
                        ALL_SET_UP, builder.getKeyboardMarkup(commandList));
                stateContext.setState(StateList.SLEEP);
            }

            checker.setSetField(null);
        }
    }
}

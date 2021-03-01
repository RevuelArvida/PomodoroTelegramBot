package ru.revuelArvida.pomodoroTelegramBot.command;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


public class KeyboardMarkupBuilder {

    public ReplyKeyboardMarkup getKeyboardMarkup(List<String> commandList){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboard = new ArrayList<>();

        int rowsNumber = (commandList.size() / 2 ) + (commandList.size() % 2);
        int commandNumber = 0;
        for (int i = 0; i < rowsNumber; i++) {
            KeyboardRow row = new KeyboardRow();

            if (commandNumber + 2 <= commandList.size()) {
                row.add(commandList.get(commandNumber++));
                row.add(commandList.get(commandNumber++));
            } else if (commandNumber + 1 <= commandList.size()) {
                row.add(commandList.get(commandNumber++));
            }

            keyboard.add(row);
        }
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
}

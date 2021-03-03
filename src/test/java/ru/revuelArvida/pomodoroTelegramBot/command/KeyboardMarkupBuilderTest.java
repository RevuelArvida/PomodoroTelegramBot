package ru.revuelArvida.pomodoroTelegramBot.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardMarkupBuilderTest {

    KeyboardMarkupBuilder keyboardMarkupBuilder;

    @BeforeEach
    public void init(){
        keyboardMarkupBuilder = new KeyboardMarkupBuilder();
    }

    @Test
    public void testGetKeyboardMarkup_whenEverythingIsOk_thenReturnKeyboardMarkup(){
        //given
        List<String> commandList = new ArrayList<>();
        commandList.add("Button 1");
        commandList.add("Button 2");
        commandList.add("Button 3");
        //when
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(getKeyboard(commandList));
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setSelective(true);
        //then
        Assertions.assertTrue(keyboardMarkupBuilder.getKeyboardMarkup(commandList).equals(replyKeyboardMarkup));
    }

    public List<KeyboardRow> getKeyboard(List<String> commandList){
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

        return keyboard;
    }



}

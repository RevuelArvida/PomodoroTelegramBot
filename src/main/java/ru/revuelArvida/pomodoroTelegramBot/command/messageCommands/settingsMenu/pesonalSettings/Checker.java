package ru.revuelArvida.pomodoroTelegramBot.command.messageCommands.settingsMenu.pesonalSettings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class Checker {


    enum SetField{
        WORK("Длительность работы"),
        SHORT("Длительность короткого перерыва"),
        LONG("Длительность большого перерыва");

        private String FieldName;

        SetField(String fieldName){
            this.FieldName = fieldName;
        }

        public String getFieldName() {
            return FieldName;
        }
    }

    private Boolean isWorkSet = false;
    private Boolean isShortBrakeSet = false;
    private Boolean isLongBreakSet = false;
    private SetField setField = null;

}

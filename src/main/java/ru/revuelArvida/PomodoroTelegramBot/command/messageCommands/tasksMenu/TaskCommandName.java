package ru.revuelArvida.PomodoroTelegramBot.command.messageCommands.tasksMenu;


public enum TaskCommandName {

    ADD("добавить задачу"),
    ADD_FIRST("добавить задачу в начало списка"),
    ADD_AT_INDEX("добавить задачу по индексу"),
    CHANGE("изменить задачу"),
    DELETE("удалить задачу"),
    EXIT("выход");

    private final String commandName;

    TaskCommandName(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return commandName;
    }

}

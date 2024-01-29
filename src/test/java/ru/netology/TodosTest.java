package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Task;
import ru.netology.manager.Todos;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(1, "Позвонить домой");

    String[] subtasks = {"Банан", "Мясо", "Хлеб"};
    Epic epic = new Epic(2, subtasks);

    Meeting meeting = new Meeting(
            3,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTask() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Бан");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTask() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("вторник");

        Assertions.assertArrayEquals(expected, actual);
    }

}

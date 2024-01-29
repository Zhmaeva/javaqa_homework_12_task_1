package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;

import java.util.Arrays;

public class TaskTest {
    SimpleTask simpleTask = new SimpleTask(1, "Сдать домашнее задание");

    String[] subtasks = {"Банка огурцов", "Укроп", "Варенье домашнее"};
    Epic epic = new Epic(2, subtasks);

    Meeting meeting = new Meeting(
            3,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    // SimpleTask
    @Test
    public void shouldMatchSimpleTaskByTitle() {
        String title = simpleTask.getTitle();
        System.out.println(title);

        boolean expected = true;
        boolean actual = simpleTask.matches("задание");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchSimpleTask() {
        boolean expected = false;
        boolean actual = simpleTask.matches("Укроп");

        Assertions.assertEquals(expected, actual);
    }

    // Epic
    @Test
    public void shouldMatchEpicBySubtask() {
        String[] epicSubtasks = epic.getSubtasks();
        System.out.println(Arrays.toString(epicSubtasks));

        boolean expected = true;
        boolean actual = epic.matches("Банка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchEpic() {
        boolean expected = false;
        boolean actual = epic.matches("subtask");

        Assertions.assertEquals(expected, actual);
    }

    // Meeting
    @Test
    public void shouldMatchMeetingByTopic() {
        String topic = meeting.getTopic();
        System.out.println(topic);

        boolean expected = true;
        boolean actual = meeting.matches("3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeetingByProject() {
        String project = meeting.getProject();
        System.out.println(project);

        boolean expected = true;
        boolean actual = meeting.matches("Банка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchMeetingByStart() {
        String start = meeting.getStart();
        System.out.println(start);

        boolean expected = false;
        boolean actual = meeting.matches("Во вторник после обеда");

        Assertions.assertEquals(expected, actual);
    }
}

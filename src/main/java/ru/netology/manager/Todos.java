package ru.netology.manager;

import ru.netology.domain.Epic;
import ru.netology.domain.Meeting;
import ru.netology.domain.SimpleTask;
import ru.netology.domain.Task;

public class Todos {
    private Task[] tasks = new Task[0]; // <- тут будут все задачи

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current Массив, в который мы хотим добавить элемент
     * @param task    Элемент, который мы хотим добавить
     * @return Возвращает новый массив, который выглядит как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    /**
     * Метод добавления задачи в список дел
     *
     * @param task Добавляемая задача
     */
    public void add(Task task) {
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }

    /**
     * Метод поиска задач, которые подходят под поисковый запрос
     *
     * @param query Поисковый запрос
     * @return Массив из подошедших задач
     */
    public Task[] search(String query) {
        Task[] result = new Task[0];
        for (Task task : tasks) {
            if (task.matches(query)) {
                result = addToArray(result, task);
            }
        }
        return result;
    }
}

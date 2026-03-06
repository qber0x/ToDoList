package ru.mikhailovri.ToDoList.repository;

import ru.mikhailovri.ToDoList.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    Task create(Task task);
    void delete(UUID uuid);
    void update(UUID uuid, Task updatedTask);
    Task getByUuid(UUID uuid);
    List<Task> getAll();
}

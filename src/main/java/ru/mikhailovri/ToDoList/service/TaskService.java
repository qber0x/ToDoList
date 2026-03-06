package ru.mikhailovri.ToDoList.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhailovri.ToDoList.entity.Task;
import ru.mikhailovri.ToDoList.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task create(Task task) {
        if (task.getName() == null || task.getName().isEmpty()) {
            throw new IllegalArgumentException("task name can not be empty");
        }

        return taskRepository.create(task);
    }

    public void delete(UUID uuid){
        isTaskExists(uuid);
       taskRepository.delete(uuid);
    }

    public void update(UUID uuid, Task updatedTask){
        isTaskExists(uuid);

        taskRepository.update(uuid, updatedTask);
    }

    public Task getByUuid(UUID uuid) {
        isTaskExists(uuid);


        return taskRepository.getByUuid(uuid);
    }

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    private void isTaskExists(UUID uuid) {
        Task t = taskRepository.getByUuid(uuid);
        if (t == null) {
            throw new IllegalArgumentException("no such task");
        }
    }

}

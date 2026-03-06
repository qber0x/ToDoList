package ru.mikhailovri.ToDoList.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mikhailovri.ToDoList.entity.Task;
import ru.mikhailovri.ToDoList.repository.TaskRepository;

import java.util.*;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private Map<UUID, Task> repository = new HashMap<>();

    @Override
    public UUID create(Task task) {
        UUID newGeneratedUuid = UUID.randomUUID();
        task.setId(newGeneratedUuid);
        repository.put(newGeneratedUuid, task);
        return newGeneratedUuid;
    }

    @Override
    public void delete(UUID uuid) {
        repository.remove(uuid);
    }

    @Override
    public void update(UUID uuid, Task updatedTask) {
        delete(uuid);
        updatedTask.setId(uuid);
        repository.put(uuid, updatedTask);
    }

    @Override
    public Task getByUuid(UUID uuid) {
        return repository.get(uuid);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(repository.values());
    }

}

package ru.mikhailovri.ToDoList.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mikhailovri.ToDoList.entity.Error;
import ru.mikhailovri.ToDoList.entity.Task;
import ru.mikhailovri.ToDoList.service.TaskService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.create(task));
    }

    @GetMapping("/tasks")
    public List<?> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskByID(@PathVariable("id") UUID taskUuid) {
        return ResponseEntity.ok(taskService.getByUuid(taskUuid));
    }

    @PutMapping("/tasks/{id}")
    public void updateTask(@PathVariable("id") UUID taskUuid,
                           @RequestBody Task newTask) {
        taskService.update(taskUuid, newTask);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable("id") UUID uuid) {
        taskService.delete(uuid);
    }
}
package ru.mikhailovri.ToDoList.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mikhailovri.ToDoList.entity.Error;
import ru.mikhailovri.ToDoList.entity.Task;
import ru.mikhailovri.ToDoList.service.TaskService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<?> createTask(@RequestBody Task task){
        try {
            return ResponseEntity.ok(taskService.create(task));
        } catch (IllegalArgumentException e) {
            log.error("Ошибка при создании задачи: {}", e.getMessage());
            return ResponseEntity.badRequest().body(Error.builder()
                    .message(e.getMessage())
                    .build());
        }
    }

}

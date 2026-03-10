package ru.mikhailovri.ToDoList.controller.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.mikhailovri.ToDoList.entity.Error;


@Slf4j
@RestControllerAdvice
public class TaskControllerHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("Ошибка при создании задачи: {}", e.getMessage());
        return ResponseEntity.badRequest().body(Error.builder()
                .message(e.getMessage())
                .build());
    }
}

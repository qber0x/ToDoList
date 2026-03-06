package ru.mikhailovri.ToDoList.entity;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Error {
    private String message;
}
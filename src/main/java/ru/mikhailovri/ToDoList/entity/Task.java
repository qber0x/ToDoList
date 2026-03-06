package ru.mikhailovri.ToDoList.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
public class Task {
    private UUID id;
    private String name;
    private Boolean status;
}

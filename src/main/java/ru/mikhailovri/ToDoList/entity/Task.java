package ru.mikhailovri.ToDoList.entity;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class Task {
    private UUID id;
    private String name;
    private Boolean status;
}

package org.example.service;

import org.example.generated.model.CreateTaskRequest;
import org.example.generated.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    Task create(CreateTaskRequest request);
}
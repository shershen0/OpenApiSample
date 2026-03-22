package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.generated.api.TasksApi;
import org.example.generated.model.CreateTaskRequest;
import org.example.generated.model.Task;
import org.example.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TasksApiController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Override
    public ResponseEntity<Task> createTask(CreateTaskRequest request) {
        Task created = taskService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

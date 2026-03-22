package org.example.service;

import org.example.generated.model.CreateTaskRequest;
import org.example.generated.model.Task;
import org.example.generated.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InMemoryTaskService implements TaskService {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll() {
        return List.copyOf(tasks);
    }

    @Override
    public Task create(CreateTaskRequest request) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(TaskStatus.OPEN);

        tasks.add(task);
        return task;
    }
}
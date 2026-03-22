package org.example.client.kotlin

import org.example.client.kotlin.api.TasksApi
import org.example.client.kotlin.model.CreateTaskRequest

fun main() {
    val tasksApi = TasksApi(basePath = "http://localhost:8080")

    val createdTask = tasksApi.createTask(
        createTaskRequest = CreateTaskRequest(
            title = "Learn OpenAPI",
            description = "Use one contract for backend and client generation"
        )
    )

    println("Created task: $createdTask")

    val tasks = tasksApi.getTasks()
    println("All tasks: $tasks")
}
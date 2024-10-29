package br.com.libdolf.taskmanager.controllers;

import br.com.libdolf.taskmanager.controllers.dtos.TaskRequest;
import br.com.libdolf.taskmanager.controllers.dtos.TaskResponse;
import br.com.libdolf.taskmanager.services.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<Page<TaskResponse>> getAllTasks(Pageable pageable) {
        return ResponseEntity.ok(taskService.findAllTasks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> postNewTask(@RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.saveNewTask(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody TaskRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(taskService.updateTask(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}

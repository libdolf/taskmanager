package br.com.libdolf.taskmanager.services;

import br.com.libdolf.taskmanager.controllers.dtos.TaskRequest;
import br.com.libdolf.taskmanager.controllers.dtos.TaskResponse;
import br.com.libdolf.taskmanager.models.Task;
import br.com.libdolf.taskmanager.repositories.TaskRepository;
import br.com.libdolf.taskmanager.utils.mapper.TaskMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public Page<TaskResponse> findAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable).map(taskMapper::toResponse);
    }

    public TaskResponse findTaskById(Long id) {
        return taskRepository.findById(id).map(taskMapper::toResponse).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public TaskResponse saveNewTask(TaskRequest request) {
       return taskMapper.toResponse(taskRepository.save(taskMapper.toEntity(request)));
    }

    public TaskResponse updateTask(TaskRequest request, Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        task.update(request);
        return taskMapper.toResponse(taskRepository.save(task));
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        taskRepository.delete(task);
    }
}

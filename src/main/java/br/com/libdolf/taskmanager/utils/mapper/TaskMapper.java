package br.com.libdolf.taskmanager.utils.mapper;

import br.com.libdolf.taskmanager.controllers.dtos.TaskRequest;
import br.com.libdolf.taskmanager.controllers.dtos.TaskResponse;
import br.com.libdolf.taskmanager.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class TaskMapper {
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "id", source = "taskId")
    public abstract TaskResponse toResponse(Task task);
    public abstract Task toEntity(TaskRequest taskRequest);
}

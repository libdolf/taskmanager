package br.com.libdolf.taskmanager.controllers.dtos;

import br.com.libdolf.taskmanager.models.utils.Priority;
import br.com.libdolf.taskmanager.models.utils.Status;

public record TaskRequest(
        String title,
        String description,
        Status status,
        Priority priority,
        Long userId
) {
}

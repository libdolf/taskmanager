package br.com.libdolf.taskmanager.controllers.dtos;

import br.com.libdolf.taskmanager.models.utils.Priority;
import br.com.libdolf.taskmanager.models.utils.Status;

import java.time.Instant;

public record TaskResponse(
        Long id,
        String title,
        String description,
        Status status,
        Priority priority,
        Long userId,
        Instant creationTimestamp,
        Instant updateTimestamp
) {
}

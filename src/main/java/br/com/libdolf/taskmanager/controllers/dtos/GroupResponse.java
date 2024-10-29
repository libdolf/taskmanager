package br.com.libdolf.taskmanager.controllers.dtos;

import java.util.List;
import java.util.Set;

public record GroupResponse(
        Long id,
        String title,
        List<TaskResponse> tasks
) {
}

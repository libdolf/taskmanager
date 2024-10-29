package br.com.libdolf.taskmanager.controllers.dtos;

import java.util.List;

public record GroupRequest(
        String title,
        List<Long> taskIds
) {
}

package br.com.libdolf.taskmanager.controllers.dtos;

public record LoginResponse(
        String accessToken,
        Long expiresIn
) {
}

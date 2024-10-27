package br.com.libdolf.taskmanager.controllers.dtos;

public record LoginRequest(
        String username,
        String password
) {
}

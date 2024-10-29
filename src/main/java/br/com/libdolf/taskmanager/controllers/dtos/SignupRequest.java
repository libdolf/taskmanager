package br.com.libdolf.taskmanager.controllers.dtos;

public record SignupRequest (
        String name,
        String username,
        String password
){
}

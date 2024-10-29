package br.com.libdolf.taskmanager.config;

import br.com.libdolf.taskmanager.controllers.dtos.SignupRequest;
import br.com.libdolf.taskmanager.models.Role;
import br.com.libdolf.taskmanager.services.SignupService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.util.Optional;
import java.util.Set;

@Configuration
public class AdminConfig implements CommandLineRunner {
    private SignupService signupService;

    public AdminConfig(SignupService signupService) {
        this.signupService = signupService;
    }


    @Override
    @Transactional
    public void run(String... args) {
        try {
            signupService.signup(
                    new SignupRequest("Admin", "admin", "123"),
                    Set.of(Role.Values.ADMIN, Role.Values.BASIC)
            );
            System.out.println("Admin user created successfully.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

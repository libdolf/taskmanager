package br.com.libdolf.taskmanager.services;

import br.com.libdolf.taskmanager.controllers.dtos.SignupRequest;
import br.com.libdolf.taskmanager.models.Role;
import br.com.libdolf.taskmanager.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SignupService {

    private final RoleService roleService;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public SignupService(RoleService roleService, UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    public void signup(SignupRequest signupRequest, Set<Role.Values> roles) {
        validateUsername(signupRequest.username());
        Set<Role> userRoles = fetchRolesByIds(roles);

        User user = buildUser(signupRequest, userRoles);
        userService.save(user);
    }


    private void validateUsername(String username) {
        userService.findByUsername(username)
                .ifPresent(user -> {
                    throw new RuntimeException("Username already in use");
                });
    }

    private Set<Role> fetchRolesByIds(Set<Role.Values> roles) {
        return roles.stream()
                .map(roleEnum -> roleService.findRoleById(roleEnum.getRoleId())
                        .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleEnum)))
                .collect(Collectors.toSet());
    }

    private User buildUser(SignupRequest signupRequest, Set<Role> roles) {
        User user = new User();
        user.setName(signupRequest.name());
        user.setUsername(signupRequest.username());
        user.setPassword(passwordEncoder.encode(signupRequest.password()));
        user.setRoles(roles);
        return user;
    }
}
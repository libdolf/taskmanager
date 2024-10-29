package br.com.libdolf.taskmanager.services;

import br.com.libdolf.taskmanager.models.Role;
import br.com.libdolf.taskmanager.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role findRoleByName(String name){
        return repository.findByName(name);
    }

    public Optional<Role> findRoleById(Long roleId) {
        return repository.findById(roleId);
    }
}

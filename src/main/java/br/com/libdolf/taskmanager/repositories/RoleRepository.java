package br.com.libdolf.taskmanager.repositories;

import br.com.libdolf.taskmanager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

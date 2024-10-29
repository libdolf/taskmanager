package br.com.libdolf.taskmanager.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "tb_groups")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String title;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks;
}

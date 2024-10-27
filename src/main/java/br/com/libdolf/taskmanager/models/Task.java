package br.com.libdolf.taskmanager.models;

import br.com.libdolf.taskmanager.models.utils.Priority;
import br.com.libdolf.taskmanager.models.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tasks")
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @NotBlank
    private String title;
    private String description;

    private Status status;
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}

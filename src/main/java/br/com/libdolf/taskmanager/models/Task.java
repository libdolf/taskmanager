package br.com.libdolf.taskmanager.models;

import br.com.libdolf.taskmanager.controllers.dtos.TaskRequest;
import br.com.libdolf.taskmanager.models.utils.Priority;
import br.com.libdolf.taskmanager.models.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

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

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @CreationTimestamp
    private Instant creationTimestamp;
    @UpdateTimestamp
    private Instant updateTimestamp;

    public void update(TaskRequest request) {
        this.title = request.title();
        this.description = request.description();
        this.priority = request.priority();
        this.status = request.status();
        this.updateTimestamp = Instant.now();
    }
}

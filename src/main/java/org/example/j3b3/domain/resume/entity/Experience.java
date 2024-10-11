package org.example.j3b3.domain.resume.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.j3b3.global.util.BaseEntity;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Experience extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resume resume;

    @Size(max = 50)
    @NotBlank
    private String groupName;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String activity;
}

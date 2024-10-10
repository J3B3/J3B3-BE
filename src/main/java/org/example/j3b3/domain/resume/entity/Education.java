package org.example.j3b3.domain.resume.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.j3b3.global.util.BaseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Education extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Enumerated(EnumType.STRING)
    private EducationType educationType;

    @Size(max = 50)
    @NotBlank
    private String schoolName;

    @NotNull
    private LocalDate admissionDate;

    private LocalDate graduationDate;

    @Size(max = 20)
    @NotNull
    @Enumerated(EnumType.STRING)
    private GraduationType graduationType;

    @Size(max = 50)
    @NotBlank
    private String major;

    @NotNull
    @Column(precision = 3, scale = 2)
    private BigDecimal major_gpa;

    @NotNull
    @Column(precision = 2, scale = 1)
    private BigDecimal max_gpa;
}

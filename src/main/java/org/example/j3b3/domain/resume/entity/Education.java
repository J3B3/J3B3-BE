package org.example.j3b3.domain.resume.entity;

import jakarta.persistence.*;
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

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private EducationType educationType;

    @Column(length = 50)
    private String schoolName;

    private LocalDate admissionDate;

    private LocalDate graduationDate;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private GraduationType graduationType;

    @Column(length = 50)
    private String major;

    @Column(precision = 3, scale = 2)
    private BigDecimal major_gpa;

    @Column(precision = 2, scale = 1)
    private BigDecimal max_gpa;
}

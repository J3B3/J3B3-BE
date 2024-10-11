package org.example.j3b3.domain.resume.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.j3b3.global.util.BaseEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Resume extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "resume")
    private List<Education> educationList;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperienceList;

    @OneToMany(mappedBy = "resume")
    private List<Language> languageList;
}

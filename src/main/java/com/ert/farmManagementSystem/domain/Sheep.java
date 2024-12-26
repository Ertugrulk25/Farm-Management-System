package com.ert.farmManagementSystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_sheep")
public class Sheep {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private LocalDate deathDate;

    @Embedded
    private VaccineInformation vaccineInformation;

}

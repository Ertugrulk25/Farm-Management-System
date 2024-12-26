package com.ert.farmManagementSystem.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_cow")
public class Cow {

    @Id
    private Integer id;

@Column(nullable = false)
    private String breed;

@Column(nullable = false)
    private LocalDate dateOfBirth;

    private LocalDate deathDate;

    @Embedded
    private VaccineInformation vaccineInformation;

    public Cow() {
    }

    public Cow(Integer id, String breed, LocalDate dateOfBirth, LocalDate deathDate, VaccineInformation vaccineInformation) {
        this.id = id;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.deathDate = deathDate;
        this.vaccineInformation = vaccineInformation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public VaccineInformation getVaccineInformation() {
        return vaccineInformation;
    }

    public void setVaccineInformation(VaccineInformation vaccineInformation) {
        this.vaccineInformation = vaccineInformation;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", deathDate=" + deathDate +
                ", vaccineInformation=" + vaccineInformation +
                '}';
    }
}



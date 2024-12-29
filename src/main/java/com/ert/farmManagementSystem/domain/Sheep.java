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

    public Sheep() {
    }

    public Sheep(Integer id, String breed, LocalDate dateOfBirth, LocalDate deathDate) {
        this.id = id;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.deathDate = deathDate;
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

    @Override
    public String toString() {
        return "Sheep{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", deathDate=" + deathDate +
                '}';
    }



}

package com.ert.farmManagementSystem.domain;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class VaccineInformation {

private String vaccineName;

private LocalDate vaccineDate;

    public VaccineInformation() {
    }

    public VaccineInformation(String vaccineName, LocalDate vaccineDate) {
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    @Override
    public String toString() {
        return "VaccineInformation{" +
                "vaccineName='" + vaccineName + '\'' +
                ", vaccineDate=" + vaccineDate +
                '}';
    }
}

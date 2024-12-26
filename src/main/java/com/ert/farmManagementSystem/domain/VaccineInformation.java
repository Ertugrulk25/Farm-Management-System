package com.ert.farmManagementSystem.domain;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class VaccineInformation {

private String vaccineName;

private LocalDate vaccineDate;

}

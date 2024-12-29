package com.ert.farmManagementSystem.service;

import com.ert.farmManagementSystem.domain.Cow;
import com.ert.farmManagementSystem.exception.CowNotFoundEXception;
import com.ert.farmManagementSystem.repository.CowRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CowService {
    private Scanner scanner = new Scanner(System.in);
    private final CowRepository cowRepository;

    public CowService(CowRepository cowRepository) {
        this.cowRepository = cowRepository;
    }

    public void saveCow() {
        Cow cow = new Cow();
        System.out.println("Enter Cow ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        cow.setId(id);
        System.out.println("Enter Cow breed: ");
        cow.setBreed(scanner.nextLine());

        System.out.println("Enter Cow date of birth");
        String dateOfBirth = scanner.nextLine();
        cow.setDateOfBirth(LocalDate.parse(dateOfBirth));

        System.out.println("Enter Cow death date: ");
        String deathDate = scanner.nextLine();
        if (deathDate != null && !deathDate.isBlank()) {
            cow.setDeathDate(LocalDate.parse(deathDate));
        } else {

            cow.setDeathDate(null);
        }
cowRepository.save(cow);

    }

    public Cow findCowById(Integer id) {
        Cow foundCow = cowRepository.findById(id);
        try {
            if (foundCow != null) {

                System.out.println(foundCow);

                return foundCow;
            } else {
                throw new CowNotFoundEXception("Cow not found by ID: ");
            }
        } catch (CowNotFoundEXception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void deleteCowById(Integer deleteId) {

        Cow deleteCow = findCowById(deleteId);

        if (deleteCow != null) {
            System.out.println(deleteCow);
            cowRepository.delete(deleteCow);
            System.out.println("Cow is deleted ");
        } else {
            System.out.println("Cow id is not found ");
        }
    }

    public void findAllCows() {
        List<Cow> cows = cowRepository.findAll();
        if (cows.isEmpty()) {
            System.out.println("Cows list is EMPTY !!!");
        } else {
            System.out.println("------------ ALL COWS ------------");
            for (Cow cow : cows) {
                System.out.println(cow);
            }
            System.out.println("------------ALL COWS ----------------");
        }


    }

    public void updateCowById(Integer updateWithId) {

        Cow foundCow = findCowById(updateWithId);

        if (foundCow != null) {

            System.out.println("Enter the new cow breed");
            String breed = scanner.nextLine();
            System.out.println("Enter new date birth");
            String newBirthDate = scanner.nextLine();
            foundCow.setDateOfBirth(LocalDate.parse(newBirthDate));
            System.out.println("Enter new death date");
            String newDeathDate = scanner.nextLine();
            foundCow.setDeathDate(LocalDate.parse(newDeathDate));




            foundCow.setBreed(breed);
            foundCow.setDateOfBirth(LocalDate.parse(newBirthDate));
            foundCow.setDeathDate(LocalDate.parse(newDeathDate));

            cowRepository.update(foundCow);


        } else {
            System.out.println("Update operation is canceled!!! ");
        }

    }
}
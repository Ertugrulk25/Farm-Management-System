package com.ert.farmManagementSystem.service;

import com.ert.farmManagementSystem.domain.Sheep;
import com.ert.farmManagementSystem.exception.CowNotFoundEXception;
import com.ert.farmManagementSystem.repository.SheepRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class SheepService {
    private Scanner scanner = new Scanner(System.in);
    private final SheepRepository sheepRepository;

    public SheepService(SheepRepository sheepRepository) {
        this.sheepRepository = sheepRepository;
    }


    public void saveCow() {
        Sheep sheep = new Sheep();
        System.out.println("Enter Sheep ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        sheep.setId(id);
        System.out.println("Enter Sheep breed: ");
        sheep.setBreed(scanner.nextLine());

        System.out.println("Enter Sheep date of birth");
        String dateOfBirth = scanner.nextLine();
        sheep.setDateOfBirth(LocalDate.parse(dateOfBirth));

        System.out.println("Enter Sheep death date: ");
        String deathDate = scanner.nextLine();
        if (deathDate != null && !deathDate.isBlank()) {
            sheep.setDeathDate(LocalDate.parse(deathDate));
        } else {


            sheep.setDeathDate(null);

        }

        sheepRepository.save(sheep);
    }


    public Sheep findSheepById(Integer findId) {

        Sheep foundSheep = sheepRepository.findById(findId);
        try {
            if (foundSheep != null) {

                System.out.println(foundSheep);

                return foundSheep;
            } else {
                throw new CowNotFoundEXception("Sheep not found by ID: ");
            }
        } catch (CowNotFoundEXception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void deleteSheepById(Integer deleteId) {
        Sheep deleteSheep = findSheepById(deleteId);

        if (deleteSheep != null) {
            System.out.println(deleteSheep);
            sheepRepository.delete(deleteSheep);
            System.out.println("Cow is deleted ");
        } else {
            System.out.println("Cow id is not found ");
        }
    }


    public void findAllSheep() {


        List<Sheep> sheep = sheepRepository.findAll();
        if (sheep.isEmpty()) {
            System.out.println("Sheep list is EMPTY !!!");
        } else {
            System.out.println("------------ ALL SHEEP ------------");
            for (Sheep sheep1 : sheep) {
                System.out.println(sheep1);
            }
            System.out.println("------------ALL SHEEP ----------------");
        }


    }

    public void updateSheepById(Integer updateWithId) {

        Sheep foundSheep = findSheepById(updateWithId);

        if (foundSheep != null) {

            System.out.println("Enter the new sheep breed");
            String breed = scanner.nextLine();
            System.out.println("Enter sheep date birth");
            String newBirthDate = scanner.nextLine();
            foundSheep.setDateOfBirth(LocalDate.parse(newBirthDate));
            System.out.println("Enter new death date");
            String newDeathDate = scanner.nextLine();
            foundSheep.setDeathDate(LocalDate.parse(newDeathDate));




            foundSheep.setBreed(breed);
            foundSheep.setDateOfBirth(LocalDate.parse(newBirthDate));
            foundSheep.setDeathDate(LocalDate.parse(newDeathDate));

            sheepRepository.update(foundSheep);


        } else {
            System.out.println("Update operation is canceled!!! ");
        }

    }
}
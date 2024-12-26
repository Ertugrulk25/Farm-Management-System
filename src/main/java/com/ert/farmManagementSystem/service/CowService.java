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
        cow.setDeathDate(LocalDate.parse(deathDate));
        // ÖLÜM TARİHİ BOŞ GİRME
        cowRepository.save(cow);
        System.out.println("Cow is saved successfully. Cow ID: "+ cow.getId());


    }

    public Cow findCowById(Integer id) {
   Cow foundCow = cowRepository.findById(id);
   try {
       if (foundCow != null) {

           System.out.println(foundCow);


       } else {
           throw new CowNotFoundEXception("Cow not found by ID: ");
       }
   }catch (CowNotFoundEXception e){
       System.out.println(e.getMessage());
   }

        return null;
    }

    public void deleteCowById(Integer deleteId) {

    Cow deleteCow = findCowById(deleteId);

    if (deleteCow!= null){
        System.out.println(deleteCow);
        cowRepository.delete(deleteCow);
        System.out.println("Cow is deleted ");
    }else {
        System.out.println("Cow id is not found ");
    }
    }

    public void findAllCows() {
        List<Cow> cows = cowRepository.findAll();
        if (cows.isEmpty()){
            System.out.println("Cows list is EMPTY !!!");
        }else {
            System.out.println("------------ ALL COWS ------------");
            for (Cow cow :cows){
                System.out.println(cow);
            }
            System.out.println("------------ALL COWS ----------------");
        }



    }
}

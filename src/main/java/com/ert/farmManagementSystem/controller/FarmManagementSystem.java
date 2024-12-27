package com.ert.farmManagementSystem.controller;

import com.ert.farmManagementSystem.repository.CowRepository;
import com.ert.farmManagementSystem.repository.SheepRepository;
import com.ert.farmManagementSystem.service.CowService;
import com.ert.farmManagementSystem.service.SheepService;

import java.util.Scanner;

public class FarmManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

public static void displayFarmManagementSystem() {
    CowRepository cowRepository = new CowRepository();
    CowService cowService = new CowService(cowRepository);

    SheepRepository sheepRepository = new SheepRepository();
    SheepService sheepService = new SheepService();


    int choice;
do {

    System.out.println("=========================  FARM MANAGEMENT SYSTEM  =================================");
    System.out.println("1. COW ");
    System.out.println("2. SHEEP ");
    System.out.println("0. EXIT ");
    System.out.println("Enter your choice:  ");
    choice =scanner.nextInt();
    scanner.nextLine();

    switch (choice){

        case 1 :
            //cow
            cowOperationMenu(cowService);
            break;
        case 2 :
            //sheep

            break;
        case 3 :
            // exıt
            break;
        default:
            System.out.println("Invalid Choice, Please Try Again...");
            break;
    }
}while (choice!=0);
}

public static void cowOperationMenu(CowService cowService){
boolean exit = false;
while (exit){
    System.out.println("*************** COW OPERATIONS **************");
    System.out.println("1. Add a new Cow ");
    System.out.println("2. Find Cow by ID: ");
    System.out.println("3. Delete Cow by ID: ");
    System.out.println("4. Find all Cows:  ");
    System.out.println("5. Update Cow by ID: :  ");
    System.out.println("0. Return to main menu : ");
    System.out.println("Enter your choice: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    switch (choice) {

        case 1:
            cowService.saveCow();
            break;
        case 2:
            System.out.println("Please Enter Cow ID: ");
            Integer findId = scanner.nextInt();
            scanner.nextLine();
            cowService.findCowById(findId);
            break;
        case 3:
            System.out.println("Enter Cow ID: ");
            Integer deleteId = scanner.nextInt();
            scanner.nextLine();
            cowService.deleteCowById(deleteId);
            break;
        case 4:

            cowService.findAllCows();
            break;
        case 5:

            break;
        case 0:
            break;

    }
    }
}
public static void sheepOperationMenu(SheepService sheepService){
boolean exit = false;
while (exit) {
    System.out.println("*************** SHEEP OPERATIONS **************");
    System.out.println("1. Add a new Sheep ");
    System.out.println("2. Find Sheep by ID: ");
    System.out.println("3. Delete Sheep by ID: ");
    System.out.println("4. Find all Sheep:  ");
    System.out.println("5. Update Sheep by ID: :  ");
    System.out.println("0. Return to main menu : ");
    System.out.println("Enter your choice: ");

}
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_cartercomeau.pkg101253879;

import java.util.*;

/**
 *
 * @author Carter Comeau Student ID: 101253879 Assignment 1 2020/10/02
 */
public class DogShelterManager {
//initialize variables

    private int numOfDogs = 0;
    private int maxNumOfDogs;
    private DogInfo[] listOfDogs;
//constructor takes max number of dogs to create a new array for dogInfo objects

    public DogShelterManager(int maxNumOfDogs) {

        this.maxNumOfDogs = maxNumOfDogs;
        this.numOfDogs = 0;
        this.listOfDogs = new DogInfo[maxNumOfDogs];
    }
//addDog method will call the dogInfo constructor and store it into the array at the next available posistion

    public boolean addDog() {

        System.out.println("\nPreparing to add dog...");
//checks capacity reached method to first see if theres room for another dog
        if (!capacityReached()) {
            System.out.println("\nYou Have Reached Shelter Capacity");
            return false;
        } else {
//returns constructor parameters by calling functions that validate input
            listOfDogs[numOfDogs] = new DogInfo(setDogId(), setName(), setAge(), setBreed(), setSex());
            this.numOfDogs++;
            System.out.println("\nDog Succesfully Added!\n");
            return true;
        }
    }
//view all dogs loops through shelter array and displays info for each dog

    public String viewAllDogs() {
//if no dogs have been added yet displays a default message
        if (numOfDogs == 0) {
            return "There are currently no dogs to display";
        } else {

            System.out.println("\nAll Dogs: ");
            String s = "";
            for (int i = 0; i < numOfDogs; i++) {
                s += listOfDogs[i].displayInfo();
            }

            return s;
        }
    }
//prints info for all dogs whos home status is false, meaning only the available dogs

    public String viewAvailableDogs() {
        System.out.println("\nAll Available Dogs: ");;
        String s = "";
        for (int i = 0; i < numOfDogs; i++) {
            if (listOfDogs[i].returnDogStatus() == false) {
                s += listOfDogs[i].displayInfo();
            }
        }
        return s;
    }
//updates homeStatus variable of a dog to true based on the ID given by user

    public boolean updateDogHomeStatus() {
        System.out.println("\nUpdating Dog Home Status...");
        Scanner keyboard = new Scanner(System.in);
        int dogId;
        System.out.print("\nDog ID: ");
        dogId = Integer.parseInt(keyboard.nextLine());

        for (int i = 0; i < numOfDogs; i++) {
            if (listOfDogs[i].getDogId() == dogId) {
                listOfDogs[i].dogFoundHome();
                System.out.println("\nDog Home Status Updated");
                return true;
            }
        }
        System.out.println("\nCould Not Locate Dog With That ID");
        return false;
    }
//returns a boolean to check if a dog with a certain ID already exists

    public boolean dogExists(int dogId) {
        for (int i = 0; i < numOfDogs; i++) {
            if (listOfDogs[i].getDogId() == dogId) {
                return true;
            }
        }
        return false;
    }
//returns info for a specific dog based on the dogs ID

    public String viewDog() {
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        int dogId = 0;
//uses a while loop to validate user input, if an exception is thrown it will loop back
        while (flag) {
            try {
                System.out.print("\nDog ID: ");
                dogId = Integer.parseInt(keyboard.nextLine());
                flag = false;
            } catch (Exception e) {
                System.out.println("\nInvalid Entry");
            }
        }

        String s = "";
//if dog ID is found it will locate that dog within the array and display info for that dog
        for (int i = 0; i < numOfDogs; i++) {
            if (listOfDogs[i].getDogId() == dogId) {
                s += listOfDogs[i].displayInfo();
                System.out.println("\nDog Found!\n");
                return s;
            }
        }
        return "\nDog Not Found";
    }
//checks if shelter has reached capicity by comparing the number of dogs and the array size

    public boolean capacityReached() {
        if (this.numOfDogs + 1 > this.maxNumOfDogs) {
            return false;
        }

        return true;
    }
//returns an int for dog ID after performing validations

    public int setDogId() {
        boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        int tempDogId;
        int dogId = 0;

        while (flag) {
            System.out.print("\nDog ID: ");
            tempDogId = Integer.parseInt(keyboard.nextLine());
//if this is the first dog then there is no need to check if the dog ID exists            
            if (numOfDogs == 0) {
                dogId = tempDogId;
                flag = false;
                return dogId;
//calls the dogExists method and passes the dog ID user is trying to set to check if that ID already exists                
            } else if (dogExists(tempDogId) == false) {
                dogId = tempDogId;
                flag = false;
                return dogId;
            } else {
                System.out.println("\nDog ID Already Exists");
            }
        }
        return 0;
    }
//returns a string for the dogs name after performing validations

    public String setName() {

        boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        String name;
        String temp;

        while (flag) {
            System.out.print("Dog Name: ");
            temp = keyboard.nextLine();
//uses a regular expression to check if dog name contains non-numeric values\
//it will also not allow empty names
            if (temp.matches(".*\\d.*") || temp.length() == 0) {
                System.out.println("Invalid Name");

            } else {
                name = temp;
                flag = false;
                return name;
            }
        }

        return "Unknown";
    }
//returns a double for the dogs age after performing validations

    public double setAge() {
        boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        double age;
        double temp;

        while (flag) {
            System.out.print("Age: ");
            temp = Double.parseDouble(keyboard.nextLine());
//validates that the age is greater than 0 and less than or equal to 25            
            if (temp > 0 && temp <= 25) {
                age = temp;
                flag = false;
                return age;
            } else {
                System.out.println("Invalid Age");
            }
        }
        return 0;
    }
//returns a string for the dogs breed after performing validations

    public String setBreed() {

        boolean flag = true;
        Scanner keyboard = new Scanner(System.in);
        String breed;
        String temp;

        while (flag) {
            System.out.print("Dog Breed: ");
            temp = keyboard.nextLine();
//uses a regular expression to check for non-numeric values
//validates that breed is not an empty string
            if (temp.matches(".*\\d.*") || temp.length() == 0) {
                System.out.println("Invalid Breed");

            } else {
                breed = temp;
                flag = false;
                return breed;
            }
        }

        return "Unknown Breed";
    }
//returns a character value for the dogs sex after performing validations    

    public char setSex() {

        Scanner keyboard = new Scanner(System.in);
        char sex = 'M';
        String temp;
        boolean flag = true;

        while (flag) {

            System.out.print("Male(M) or Female(F): ");
            sex = Character.toUpperCase(keyboard.next().charAt(0));

            if (sex == 'M' || sex == 'F') {
                flag = false;
                return sex;
            } else {
                System.out.println("\nInvalid Sex\n");
                System.out.println("\nPlease enter Male or Female\n");
            }
        }
        return sex;
    }
}

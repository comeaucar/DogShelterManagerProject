package assignment1_cartercomeau.pkg101253879;

import java.util.*;

/**
 *
 * @author  Carter Comeau 
 *          Student ID: 101253879 
 *          Assignment 1 
 *          2020/10/02
 */
public class Assignment1_CarterComeau101253879 {
//display menu is a function that returns users choice

    public static int displayMenu() {

        //Scanner object for user input
        Scanner choice = new Scanner(System.in);
        int selection = 0;

        System.out.println("What would you like to do?");
        System.out.println("1. Add Dog");
        System.out.println("2. View All Dogs");
        System.out.println("3. View All Available Dogs");
        System.out.println("4. View Dog");
        System.out.println("5. Update Dog Home Status");
        System.out.println("6. Exit");
        System.out.print("Enter Choice: ");
        selection = Integer.parseInt(choice.nextLine());

        return selection;
    }

    public static void main(String[] args) {
        //initialize variables
        Scanner keyboard = new Scanner(System.in);
        int maxDogCount = 0;
        boolean flag = true;
        boolean flagTwo = true;
        //intro message
        System.out.println("Hello and welcome to your dog shelter!");

        //while loop to validate user input along with try-catch
        while (flagTwo) {
            try {

                //takes integer from user to create array of that size, this is how many dogs the facility can handle        
                System.out.println("How many dogs can your facility handle?");
                System.out.print("Enter Number: ");

                maxDogCount = Integer.parseInt(keyboard.nextLine());
                flagTwo = false;
            } catch (Exception e) {
                System.out.println("Invalid Number");
            }
        }
        //create new dog shelter array of user input size
        DogShelterManager newShelter = new DogShelterManager(maxDogCount);

        //while loop to allow user to use program until they are finished
        while (flag) {

            try {

                //switch statement with the displayMenu() method  
                switch (displayMenu()) {

                    case 1:
                        try {
                            newShelter.addDog();
                            System.out.println("Press Enter To Continue");
                            keyboard.nextLine();
                            break;
                        } catch (Exception y) {
                            System.out.println("Invalid Entry");
                            break;
                        }

                    case 2:
                        System.out.println(newShelter.viewAllDogs());
                        System.out.println("Press Enter To Continue");
                        keyboard.nextLine();
                        break;

                    case 3:
                        System.out.println(newShelter.viewAvailableDogs());
                        System.out.println("Press Enter To Continue");
                        keyboard.nextLine();
                        break;

                    case 4:
                        System.out.println(newShelter.viewDog());
                        System.out.println("Press Enter To Continue");
                        keyboard.nextLine();
                        break;

                    case 5:
                        newShelter.updateDogHomeStatus();
                        System.out.println("Press Enter To Continue");
                        keyboard.nextLine();
                        break;

                    case 6:
                        System.out.println("Goodbye For Now!");
                        flag = false;
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("\nInvalid Entry");
                System.out.println("\nPlease Enter Valid Number\n");
                continue;
            }

        }
    }

}

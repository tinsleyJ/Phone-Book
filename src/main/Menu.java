package main;

import java.util.Scanner;

public class Menu {

    static void menu() {
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("""
                    ==========================================PHONE BOOK==========================================
                        1 - Add new entry
                        2 - Search by name
                        3 - Search by telephone number
                        4 - Search by city or state
                        5 - Delete a record for a given telephone number
                        6 - Update a record for a given telephone number
                        7 - Show all records in ascending order
                        8 - Exit
                    ==============================================================================================
                    """);
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    Scanner strIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the record you would like to add to the phone book:
                            ==============================================================================================
                            """);
                    String recordToUpdate = strIn.nextLine();
                    System.out.println("==============================================================================================");
                    System.out.println("'FixMe' has been added to the phone book.");
                    System.out.println("==============================================================================================");
                    repeatMenu();
                }
                case 2 -> {
                    Scanner intIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            1 - Search by first name.
                            2 - Search by last name.
                            3 - Search by full name.
                            4 - Go back.
                            ==============================================================================================
                            """);
                    int searchChoice = intIn.nextInt();
                    switch (searchChoice) {
                        case 1 -> {
                            // Search by first name
                        }
                        case 2 -> {
                            // Search by last name
                        }
                        case 3 -> {
                            // Search by full name
                        }
                        case 4 -> {
                            return;
                        }
                    }
                    repeatMenu();
                }
                case 3 -> {
                    Scanner strIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the number you would like to search by:
                            ==============================================================================================
                            """);
                    String phoneNumberSearch = strIn.nextLine();
                    repeatMenu();
                }
                case 4 -> {
                    Scanner strIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the city or state you would like to search by:
                            ==============================================================================================
                            """);
                    String locationSearch = strIn.nextLine();
                    repeatMenu();
                }
                case 5 -> {
                    Scanner strIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the telephone number of the record you would like to delete:
                            ==============================================================================================
                            """);
                    String phoneNumberDelete = strIn.nextLine();
                    repeatMenu();
                }
                case 6 -> {
                    Scanner strIn = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the telephone number of the record you would like to update:
                            ==============================================================================================
                            """);
                    String phoneNumberUpdate = strIn.nextLine();
                    repeatMenu();
                }
                case 7 -> {
                    // Display all records in Ascending order
                    repeatMenu();
                }
                case 8 -> {
                    System.out.println("Book closed, Have a nice day!");
                    System.exit(0);
                }
            }

    }while (true);
    }
        public static void repeatMenu() {
            Scanner input = new Scanner(System.in);

            int reRunMenu;
            do {
                System.out.println("""
                 ==============================================================================================
                 Return to main menu?
                 1:\t  Yes
                 2:\t  No
                 ==============================================================================================""");
                reRunMenu = input.nextInt();
                if (reRunMenu < 1 || reRunMenu > 2) {
                    do {
                        System.out.println("Please enter a valid option.");
                        System.out.println("""
                            ==============================================================================================
                            Return to main menu?
                            1:\t  Yes
                            2:\t  No
                            ==============================================================================================""");
                        reRunMenu = input.nextInt();
                    } while (reRunMenu < 1 || reRunMenu > 2);
                } else if (reRunMenu == 1) {
                    break;
                } else {
                    System.out.println("Book closed, Have a nice day!");
                    System.exit(0);
                }
            } while (true);

        }


}

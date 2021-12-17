package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Methods m = new Methods();

//        ==================================== Some test Cases ====================================
        m.createPhoneBookEntry("Jon Thomas Tinsley, 1234 MadeUp street, Dover, AR, 72837, 1234567890");
        m.createPhoneBookEntry("John Doe, 114 Market St, St Louis, MO, 63403, 6366435698");
        m.createPhoneBookEntry("John E Doe, 324 Main St, St Charles, MO,63303, 8475390126");
        m.createPhoneBookEntry("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
        System.out.println(Arrays.toString(m.searchByFirstName("john")));
        System.out.println(Arrays.toString(m.searchByLastName("doe")));
        System.out.println(Arrays.toString(m.searchByFullName("john", "doe")));

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
                    String recordToAdd = strIn.nextLine();
                    m.createPhoneBookEntry(recordToAdd);
                    repeatMenu();
                }
                case 2 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            1 - Search by first name.
                            2 - Search by last name.
                            3 - Search by full name.
                            4 - Go back.
                            ==============================================================================================
                            """);
                    int searchChoice = sc.nextInt();
                    switch (searchChoice) {
                        case 1 -> {
                            System.out.println("""
                                    ==============================================================================================
                                    Enter the first name to search for:
                                    ==============================================================================================
                                    """);
                            String fNameSearch = sc.next();
                            System.out.println(Arrays.toString(m.searchByFirstName(fNameSearch)));
                        }
                        case 2 -> {
                            System.out.println("""
                                    ==============================================================================================
                                    Enter the last name to search for:
                                    ==============================================================================================
                                    """);
                            String lNameSearch = sc.next();
                            System.out.println(Arrays.toString(m.searchByLastName(lNameSearch)));
                        }
                        case 3 -> {
                            System.out.println("""
                                    ==============================================================================================
                                    Enter the first name to search for:
                                    ==============================================================================================
                                    """);
                            String fNameSearch = sc.next();
                            System.out.println("""
                                    ==============================================================================================
                                    Enter the Last Name to search for:
                                    ==============================================================================================
                                    """);
                            String lNameSearch = sc.next();
                            System.out.println(Arrays.toString(m.searchByFullName(fNameSearch, lNameSearch)));
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
                    long phoneNumberSearch = strIn.nextLong();
                    m.searchByPhoneNumber(phoneNumberSearch);
                    repeatMenu();
                }
                case 4 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            1 - Search by city
                            2 - Search by state
                            ==============================================================================================
                            """);
                    int locationSearchChoice = sc.nextInt();
                    switch (locationSearchChoice) {
                        case 1 -> {

                            System.out.println("""
                                    ==============================================================================================
                                    Enter the city name to search for:
                                    ==============================================================================================
                                    """);
                            String citySearch = sc.next();
                            System.out.println(m.searchByCity(citySearch));
                            repeatMenu();
                        }
                        case 2 -> {
                            System.out.println("""
                                    ==============================================================================================
                                    Enter the state to search for:
                                    ==============================================================================================
                                    """);
                            String stateSearch = sc.next();
                            System.out.println(m.searchByState(stateSearch));
                            repeatMenu();
                        }
                    }
                }
                case 5 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the telephone number of the record you would like to delete:
                            ==============================================================================================
                            """);
                    long phoneNumberDelete = sc.nextLong();
                    m.deletePerson(phoneNumberDelete);
                    repeatMenu();
                }
                case 6 -> {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("""
                            ==============================================================================================
                            Enter the telephone number of the record you would like to update:
                            ==============================================================================================
                            """);
                    long phoneNumberUpdate = sc.nextLong();
                    m.updatePerson(phoneNumberUpdate);
                    repeatMenu();
                }
                case 7 -> {
                    // Display all records in Ascending order
                    m.fullSort();
                    repeatMenu();
                }
                case 8 -> {
                    System.out.println("Book closed, Have a nice day!");
                    System.exit(0);
                }
            }

        } while (true);
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

//      Write a program to simulate the actions of a phonebook. (s)
//         Your program should be able to :
// •	Add new entries
// •	Search for an existing entry
// •	Search by first name *
// •	Search by last name *
// •	Search by full name *note name is not unique therefore the result should be an array of Person Objects.
// •	Search by telephone number
// •	Search by city or state
// •	Delete a record for a given telephone number
// •	Update a record for a given telephone number
// •	Show all records in asc order *note you will need to research sorting on an array.
// •	An option to exit the program
//         Your program should operate on the console. It should display all the choices when the program loads.
//              Eg 1. Add new record 2. Delete a record Etc.. where 1 representing the action for adding a record
//              and 2 representing the action for deleting a record.
//         Your program should run until the user selects the exit option.
//         Your program should have a minimum of 2 classes a Person class, an Address  class.
//
//         Test case :
//         "John Doe, 114 Market St, St Louis, MO, 63403, 6366435698"
//         "John E Doe, 324 Main St, St Charles, MO,63303, 8475390126"
//         "John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375"
//         Note: Test cases should work when copy and paste into the console as one entry (as is).
//         ONLY ARRAYS ARE ALLOWED, NO ARRAYLIST.
//
//      Searching for John should return a list of all 3 records above, displaying the telephone number in this order (636)-453-8563.
//
//         Optional add additional features to your program, for storing cell, home, work and fax numbers.
//         Also features for storing events like birthday, anniversary, email… etc




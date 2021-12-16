package main;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

//        Address a1 = new Address("1234 MadeUp street", "Dover", "Arkansas", 72837);
//        Address a2 = new Address("1234 BB Lane", "Haroldson", "Utah", 12345);
//        Address a3 = new Address("1234 LOTR Road", "Shire", "Middle Earth", 72153);
//
//        Person p1 = new Person("Jon", "Thomas", "Tinsley", 1234567890, a1);
//        Person p2 = new Person("Bill", "W", "Weasley", 1234567890, a2);
//        Person p3 = new Person("Sam", "Flint", "Gamsy", 1231212348, a3);
//
//        Person.write("people.txt", p1, a1);
//        Person.write("people.txt", p2, a2);
//        Person.write("people.txt", p3, a3);

//        Person.fullFileRead("people.txt");
        String firstNameToSearch = "jon";
        String lastNameToSearch = "gamsy";
        String firstNameToSearch2 = "bill";
        String lastNameToSearch2 = "weasley";
        String theFile = "people.txt";
        long thePhoneNumber = 1231564874;
        String theCityState = "shire";
        System.out.println("Your search for first name'" + firstNameToSearch + "' returned:\n" + (Arrays.toString(Person.searchByFirstName(theFile, firstNameToSearch))) + "\n");
        System.out.println("Your search for last name'" + lastNameToSearch + "' returned:\n" + Arrays.toString(Person.searchByLastName(theFile, lastNameToSearch)) + "\n");
        System.out.println("Your search for full name '" + firstNameToSearch2 + " " + lastNameToSearch2 + "' returned:\n" + Arrays.toString(Person.searchByFullName(theFile, firstNameToSearch2, lastNameToSearch2)) + "\n");
        System.out.println("Your search by phone number'" + thePhoneNumber + "' returned:\n" + Arrays.toString(Person.searchByPhoneNumber(theFile, thePhoneNumber)) + "\n");
        System.out.println("Your search by city/state '" + theCityState + "' returned:\n" + Arrays.toString(Person.searchByCityState(theFile, theCityState)) + "\n");
        System.out.println(Arrays.toString(Person.readLineToStringArr(theFile)));
//        Menu.menu();
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
//         John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
//         John E Doe, 324 Main St, St Charles, MO,63303, 8475390126
//         John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
//         Note: Test cases should work when copy and paste into the console as one entry (as is).
//         ONLY ARRAYS ARE ALLOWED, NO ARRAYLIST.
//
//      Searching for John should return a list of all 3 records above, displaying the telephone number in this order (636)-453-8563.
//
//         Optional add additional features to your program, for storing cell, home, work and fax numbers.
//         Also features for storing events like birthday, anniversary, email… etc




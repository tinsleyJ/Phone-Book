package main;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Address a1 = new Address("1234 Made Up street", "Dover", "Arkansas", 72837);
        Address a2 = new Address("1234 BB Lane", "Haroldson", "Utah", 12345);
        Address a3 = new Address("1234 LOTR Road", "Shire", "Middle Earth", 72153);

        Person p1 = new Person("Jon", "Thomas", "Tinsley", a1, 1234567890);
        Person p2 = new Person("Bill", "W", "Weasley", a2, 1234567890);
        Person p3 = new Person("Sam", "Flint", "Gamsy", a3, 1231212348);

//        WriteToFile.write("people.txt", p1);
//        WriteToFile.write("people.txt", p2);
//        WriteToFile.write("people.txt", p3);
//        ReadFromFile.fullFileRead("people.txt");
        ReadFromFile.searchFile("people.txt", "lo");
        // Menu.menu();
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




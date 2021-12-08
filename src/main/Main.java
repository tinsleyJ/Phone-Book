package main;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Jon", "Thomas", "Tinsley", "123 MakeBelieve Street",
                "Townley", "Arkansas", 1234567890, 12345);

        System.out.println(p1);

        // Menu.menu();
    }
}

//         Write a program to simulate the actions of a phonebook. (s)
//                 Your program should be able to :
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
//         Your program should operate on the console. It should display all the choices when the program loads. Eg 1. Add new record 2. Delete a record Etc.. where 1 representing the action for adding a record and 2 representing the action for deleting a record.
//                 Your program should run until the user selects the exit option.
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




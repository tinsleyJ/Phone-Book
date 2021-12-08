package main;

public class Person extends PhoneBookEntries {


    public Person(String firstName, String middleName, String lastName, String address, String city, String state, long phone, int zip) {
        super(firstName, middleName, lastName, address, city, state, phone, zip);
    }

    @Override
    public String toString() {
        return "Contact: " + "" +
                "\tFirst Name: " + firstName + '\n' +
                "\t\t\tMiddle Name: " + middleName + '\n' +
                "\t\t\tLast Name: " + lastName + '\n' +
                "\t\t\tAddress: " + Address + '\n' +
                "\t\t\tCity: " + city + '\n' +
                "\t\t\tState: " + state + '\n' +
                "\t\t\tPhone: " + phone + '\n' +
                "\t\t\tZip: " + zip;
    }

}

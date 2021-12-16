package main;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Person {

    static Person p = new Person();
    static Address a = new Address();

    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected long phone;
    protected Address address;

    public Person() {

    }

    public Person(String firstName, String middleName, String lastName, long phone, Address address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + ", " + address + ", " + phoneNumberFormat(phone);
    }

    // Writes person object to text file
    public static void write(String textFile, Person p, Address a) {
        try (FileWriter fw = new FileWriter(textFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(p.firstName + "; " + p.middleName + "; " + p.lastName + "; " +
                    a.street + "; " + a.city + "; " + a.state + "; " + a.zipCode + "; " + p.phone);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Searches entire file for any matching part of string
    public static String searchFile(String textFile, String searchString) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(textFile));
        String line = null;
        while (sc.hasNext()) {
            line = sc.nextLine();
            if (line.toLowerCase().contains(searchString.toLowerCase())) {
                return line;
            }
        }
        return line;
    }

    // Searches file for first name match
    public static Person[] searchByFirstName(String textFile, String searchString) throws IOException {
        String[] split = searchFile(textFile, searchString).split("; ");
        p.firstName = split[0];
        p.middleName = split[1];
        p.lastName = split[2];
        a.street = split[3];
        a.city = split[4];
        a.state = split[5];
        a.zipCode = Integer.parseInt(split[6]);
        p.phone = Long.parseLong(split[7]);
        if (p.firstName.equalsIgnoreCase(searchString)) {
            return new Person[0];
        }
        return null;
    }


    // Searches file for last name match
    public static Person[] searchByLastName(String textFile, String searchString) throws IOException {
        String[] split = searchFile(textFile, searchString).split("; ");
        p.firstName = split[0];
        p.middleName = split[1];
        p.lastName = split[2];
        a.street = split[3];
        a.city = split[4];
        a.state = split[5];
        a.zipCode = Integer.parseInt(split[6]);
        p.phone = Long.parseLong(split[7]);
        if (p.lastName.equalsIgnoreCase(searchString)) {
            return convertToPersonObj(Arrays.toString(split));
        } else
            return null;
    }

    // Searches file for full name match
    public static Person[] searchByFullName(String textFile, String searchString1, String searchString2) throws
            IOException {
        String[] split = searchFile(textFile, searchString1).split("; ");
        p.firstName = split[0];
        p.middleName = split[1];
        p.lastName = split[2];
        a.street = split[3];
        a.city = split[4];
        a.state = split[5];
        a.zipCode = Integer.parseInt(split[6]);
        p.phone = Long.parseLong(split[7]);
        if (p.firstName.equalsIgnoreCase(searchString1) && p.lastName.equalsIgnoreCase(searchString2)) {
            return (convertToPersonObj(Arrays.toString(split)));
        } else {
            return null;
        }
    }

    public static Person[] searchByPhoneNumber(String textFile, Long searchLong) throws IOException {
        String[] split = searchFile(textFile, String.valueOf(searchLong)).split("; ");
        p.firstName = split[0];
        p.middleName = split[1];
        p.lastName = split[2];
        a.street = split[3];
        a.city = split[4];
        a.state = split[5];
        a.zipCode = Integer.parseInt(split[6]);
        p.phone = Long.parseLong(split[7]);
        if (p.phone == (searchLong)) {
            return (convertToPersonObj(Arrays.toString(split)));
        } else {
            return null;
        }
    }

    public static Person[] searchByCityState(String textFile, String searchCityState) throws IOException {

        String[] split = searchFile(textFile, searchCityState).split("; ");
        p.firstName = split[0];
        p.middleName = split[1];
        p.lastName = split[2];
        a.street = split[3];
        a.city = split[4];
        a.state = split[5];
        a.zipCode = Integer.parseInt(split[6]);
        p.phone = Long.parseLong(split[7]);
        if (a.city.equalsIgnoreCase(searchCityState) || (a.state.equalsIgnoreCase(searchCityState))) {
            return (convertToPersonObj(Arrays.toString(split)));
        } else {
            return null;
        }

    }

    // Formats phone number integer to a proper phone number
    public static String phoneNumberFormat(long n) {
        String temp = Long.toString(n);
        int[] n2 = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            n2[i] = temp.charAt(i) - '0';
        }
        return "(" + n2[0] + n2[1] + n2[2] + ") " + n2[3] + n2[4] + n2[5] + "-" + n2[6] + n2[7] + n2[8] + n2[9];
    }

    // Converts returned object to Person
    public static Person[] convertToPersonObj(String s) throws IOException {
        Address a1 = new Address(a.street, a.city, a.state, a.zipCode);
        Person p1 = new Person(p.firstName, p.middleName, p.lastName, p.phone, a1);
        return new Person[]{p1};
    }

    // Returns full sorted file
    public static String[] readLineToStringArr(String textFile) throws IOException {
        FileReader fr = new FileReader(textFile);
        BufferedReader br = new BufferedReader(new FileReader(textFile));
        String[] arr = new String[5];
        arr[0] = br.readLine();
        if (br.readLine() != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = br.readLine();
            }
        }
        return arr;
    }

    public static String[] fullFileSort(String textFile) throws IOException {
        readLineToStringArr(textFile);

        return new String[0];
    }

    public static int getFileLength(String textFile) {
        int count = 0;
        try {
            File file = new File(textFile);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return count;
    }

}

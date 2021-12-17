package main;

import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    private Person[] currentPersonsList = new Person[0];

    public Person[] getPerson() {
        return currentPersonsList;
    }

    public void setPerson(Person[] p) {
        this.currentPersonsList = p;
    }

    // Creates new Person Object - Needs some work to get rid of extra spaces and off indexes
    public void createPhoneBookEntry(String str) {

        Person n = new Person();
        Address a = new Address();

        String[] result = str.split(",");
        for (int i = 0; i < result.length - 1; i++) {
            result[i] = result[i].replaceAll("[^\\w]", " ");
        }
        String[] strName = result[0].split(" ");
        String[] strStreet = result[1].split(" ");
        String[] strCity = result[2].split(" ");
        String[] strState = result[3].split(" ");
        int intZip = Integer.parseInt(result[4].replaceAll("[^\\w]", ""));
        long longPhone = Long.parseLong(result[5].replaceAll("[^\\w]", ""));

        if (strName.length > 3) {
            n.setFirstName(strName[0]);
            n.setMiddleName(strName[1] + " " + strName[2]);
            n.setLastName(strName[3]);

        } else if (strName.length > 2) {
            n.setFirstName(strName[0]);
            n.setMiddleName(strName[1]);
            n.setLastName(strName[2]);
        } else {
            n.setFirstName(strName[0]);
            n.setMiddleName("");
            n.setLastName(strName[1]);
        }
        if (strCity.length > 2) {
            a.setCity(strCity[1] + " " + strCity[2]);
        } else {
            a.setCity(strCity[1]);
        }
        n.setAddress(a);
        a.setStreet(strStreet[1] + " " + strStreet[2] + " " + strStreet[3]);
        a.setState(strState[1]);
        a.setZipCode(intZip);
        n.setPhone(longPhone);

        Person[] temp = new Person[currentPersonsList.length + 1];
        for (int i = 0; i < currentPersonsList.length; i++) {
            temp[i] = currentPersonsList[i];
        }
        temp[temp.length - 1] = n;
        setPerson(temp);
        System.out.println(n + "--- has been added to the phone book.");
    }

    // Searches for first name match
    public Person[] searchByFirstName(String searchString) {
        int c = 0;

        for (Person value : currentPersonsList) {
            if (value.getFirstName().equalsIgnoreCase(searchString)) {
                c++;
            }
        }
        Person[] temp = new Person[c];
        int k = 0;
        for (Person person : currentPersonsList) {
            if (person.getFirstName().equalsIgnoreCase(searchString)) {
                temp[k] = person;
                k++;
            }
        }

        return temp;
    }


    // Searches for last name match
    public Person[] searchByLastName(String lastName) {
        int c = 0;

        for (Person value : currentPersonsList) {
            if (value.getLastName().equalsIgnoreCase(lastName)) {
                c++;
            }
        }
        Person[] temp = new Person[c];
        int k = 0;
        for (Person person : currentPersonsList) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                temp[k] = person;
                k++;
            }
        }

        return temp;
    }

    // Searches for full name match
    public Person[] searchByFullName(String searchString1, String searchString2) {
        if (currentPersonsList.length == 0) {
            throw new NullPointerException("There are no entries");
        }
        int c = 0;

        for (Person value : currentPersonsList) {
            if (value.getFirstName().equalsIgnoreCase(searchString1) && value.getLastName().equalsIgnoreCase(searchString2)) {
                c++;
            }
        }
        Person[] temp = new Person[c];
        int k = 0;
        for (Person person : currentPersonsList) {
            if (person.getFirstName().equalsIgnoreCase(searchString1) && person.getLastName().equalsIgnoreCase(searchString2)) {
                temp[k] = person;
                k++;
            }
        }
        return temp;
    }

    // Search for phone number match
    public Person[] searchByPhoneNumber(long searchLong) {
        int count = 0;
        for (Person p : currentPersonsList) {
            if (p.getPhone() == searchLong) {
                count++;
            }
        }
        Person[] temp = new Person[count];
        int k = 0;
        for (Person p : currentPersonsList) {
            if (p.getPhone() == searchLong) {
                temp[k] = p;
                k++;
            }
        }
        return temp;
    }

    // Search for city match
    public String searchByCity(String searchString) {

        int count = 0;
        for (Person p : currentPersonsList) {
            if (p.getAddress().getCity().equalsIgnoreCase(searchString)) {
                count++;
            }
        }
        Person[] temp = new Person[count];
        int k = 0;
        for (Person p : currentPersonsList) {
            if (p.getAddress().getCity().equalsIgnoreCase(searchString)) {
                temp[k] = p;
                k++;
            }
        }
        return Arrays.toString(temp);
    }

    // Search for state match
    public String searchByState(String searchString) {

        int count = 0;
        for (Person p : currentPersonsList) {
            if (p.getAddress().getState().equalsIgnoreCase(searchString)) {
                count++;
            }
        }
        Person[] temp = new Person[count];
        int k = 0;
        for (Person p : currentPersonsList) {
            if (p.getAddress().getState().equalsIgnoreCase(searchString)) {
                temp[k] = p;
                k++;
            }
        }
        return Arrays.toString(temp);
    }

    public void fullSort() {
        Person temp;
        for (int i = 0; i < currentPersonsList.length; i++) {
            for (int j = 0; j < currentPersonsList.length; j++) {
                if (currentPersonsList[i].getFirstName().compareTo(currentPersonsList[j].getFirstName()) < 0) {
                    temp = currentPersonsList[i];
                    currentPersonsList[i] = currentPersonsList[j];
                    currentPersonsList[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(currentPersonsList));
    }

    // Have searchByPhoneNumber return long instead of toString
    public void deletePerson(long phone) {
        Person[] personEntries = getPerson();
        Person p = searchByPhoneNumber(phone)[0];
        Person[] uPeople = new Person[personEntries.length - 1];
        for (int i = 0; i < personEntries.length; i++) {
            Person nPerson = personEntries[i];
            if (nPerson.equals(p)) {
                continue;
            } else {
                uPeople[i] = nPerson;
            }
        }
        setPerson(uPeople);
        print(uPeople);
    }

    public void updatePerson(long phone) {
        Person p = searchByPhoneNumber(phone)[0];
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                ===================================================
                Which record would you like to update?
                1 - First Name
                2 - Middle Name
                3 - Last Name
                4 - Phone Number
                5 - Street Address
                6 - City
                7 - State
                8 - Zip Code
                ===================================================""");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Please enter the new value:");
                String newFirstName = sc.next();
                p.setFirstName(newFirstName);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 2 -> {
                System.out.println("Please enter the new value:");
                String newMiddleName = sc.next();
                p.setMiddleName(newMiddleName);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 3 -> {
                System.out.println("Please enter the new value:");
                String newLastName = sc.next();
                p.setLastName(newLastName);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 4 -> {
                System.out.println("Please enter the new value:");
                long newPhone = sc.nextLong();
                p.setPhone(newPhone);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 5 -> {
                System.out.println("Please enter the new value:");
                String newStreetAddress = sc.next();
                p.getAddress().setStreet(newStreetAddress);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 6 -> {
                System.out.println("Please enter the new value:");
                String newCity = sc.next();
                p.getAddress().setCity(newCity);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 7 -> {
                System.out.println("Please enter the new value:");
                String newState = sc.next();
                p.getAddress().setState(newState);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            case 8 -> {
                System.out.println("Please enter the new value:");
                int newZipCode = sc.nextInt();
                p.getAddress().setZipCode(newZipCode);
                System.out.println("Your updated entry looks like: " + p);
                Main.repeatMenu();
            }
            default -> {
            }
        }
    }

    // Formats phone number integer to a proper phone number
    public String phoneNumberFormat(long n) {
        String temp = Long.toString(n);
        int[] n2 = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            n2[i] = temp.charAt(i) - '0';
        }
        return "(" + n2[0] + n2[1] + n2[2] + ") " + n2[3] + n2[4] + n2[5] + "-" + n2[6] + n2[7] + n2[8] + n2[9];
    }

    public void print(Person[] p) {
        for (Person peep : p) {
            System.out.println(peep.toString());
        }
    }

    public String[] splitPerson(String k) {
        String[] spl = k.split(" ");
        String firstName = spl[0].replaceAll(" ", "");
        String lastName = spl[1].replace(" ", "");
        return new String[]{firstName + lastName};
    }


}


//================================================================================
//      Some leftovers from when I wanted to use a text file for storage
//================================================================================
//
//    public int getFileLength(String textFile) {
//        int count = 0;
//        try {
//            File file = new File(textFile);
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                sc.nextLine();
//                count++;
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return count;
//    }

//    // Converts returned object to Person
//    public Person[] convertToPersonObj(String s) throws IOException {
//        Address a1 = new Address(a.street, a.city, a.state, a.zipCode);
//        Person p1 = new Person(p.firstName, p.middleName, p.lastName, p.phone, a1);
//        return new Person[]{p1};
//    }
//
//    // Returns full sorted file
//    public String[] readLineToStringArr(String textFile) throws IOException {
//        FileReader fr = new FileReader(textFile);
//        BufferedReader br = new BufferedReader(new FileReader(textFile));
//        String[] arr = new String[Person.getFileLength(textFile)];
//        if (br.readLine() != null) {
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = br.readLine();
//            }
//        }
//        return arr;
//    }
//
//    }
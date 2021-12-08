package main;

public abstract class PhoneBookEntries {

    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String Address;
    protected String city;
    protected String state;
    protected long phone;
    protected int zip;

    public PhoneBookEntries(String firstName, String middleName, String lastName,
                            String address, String city, String state, long phone, int zip) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        Address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}

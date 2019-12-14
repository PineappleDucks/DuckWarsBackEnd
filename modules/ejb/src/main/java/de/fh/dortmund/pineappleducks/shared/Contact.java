package de.fh.dortmund.pineappleducks.shared;

public class Contact {

    private String firstName;
    private String lastName;
    private String image;
    private int contactId;

    //int counting up to generate ContactId
    private static int idCounter;


    //---------------------Constructors:-----------------------

    public Contact() {
        contactId = ++idCounter;
        idCounter++;
    }

    public Contact(String firstName) {
        this.firstName = firstName;
        contactId = ++idCounter;
        idCounter++;
    }

    public Contact(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        contactId = ++idCounter;
        idCounter++;
    }

    public Contact(String firstName, String lastName, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        contactId = ++idCounter;
        idCounter++;
    }

    //-------------------------Methods:-----------------------

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", image='" + image + '\'' +
                ", contactId=" + contactId +
                '}';
    }


    //-------------------getter and setter--------------------

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getContactId() {
        return contactId;
    }

//    public void setContactId(int contactId) {
//        this.contactId = contactId;
//    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Contact.idCounter = idCounter;
    }
}

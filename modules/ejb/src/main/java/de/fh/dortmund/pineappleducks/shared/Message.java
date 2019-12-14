package de.fh.dortmund.pineappleducks.shared;

public class Message {
    private String text;
    private String date;
    private int messageId;
    private Contact author;

    //int counting up to generate messageId
    private static int idCounter;

    //---------------------Constructors:-----------------------

    public Message() {
        messageId = ++idCounter;
        idCounter++;
    }

    public Message(String text, Contact author) {
        this.text = text;
        this.author = author;
        messageId = ++idCounter;
        idCounter++;
    }

    public Message(String text, String date, Contact author) {
        this.text = text;
        this.date = date;
        this.author = author;
        messageId = ++idCounter;
        idCounter++;
    }

    //-------------------------Methods:-----------------------

    @Override
    public String toString() {
        return "MESSAGE{" +
                "text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", messageId=" + messageId +
                ", author=" + author.toString() +
                '}';
    }


//    @Override
//    public String toString(){
//        return("Contact:(firstName = \"" +firstName+ "\", lastName = \"" +lastName+ "\", image = \"" +image+ "\", contactId = \"" +contactId+ "\")");
//    }

    //-------------------getter and setter--------------------

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    // nicht notwendig?
//    public void setDate(String date) {
//        this.date = date;
//    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Contact getAuthor() {
        return author;
    }

    public void setAuthor(Contact author) {
        this.author = author;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Message.idCounter = idCounter;
    }
}

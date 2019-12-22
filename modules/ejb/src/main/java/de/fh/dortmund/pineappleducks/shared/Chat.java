package de.fh.dortmund.pineappleducks.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Chat {

    private ArrayList<Message> messageList;
    private Contact contact;
    private int backgroundId;
    private int chatId;

    //int counting up to generate chatId
    private static int idCounter;

    //---------------------Constructors:-----------------------

    public Chat() {
        chatId = ++idCounter;
        idCounter++;
    }
    //Constructs a Chat Object out of a single message and an author
    public Chat(Message message, Contact contact) {
        messageList = new ArrayList<Message>();
        messageList.add(message);
        this.contact = contact;
        chatId = ++idCounter;
        idCounter++;
    }

    //Constructs a Chat Object out of a single message, the author from the message is the contact of this chat
    public Chat(Message message) {
        messageList = new ArrayList<Message>();
        messageList.add(message);
        contact = message.getAuthor();
        chatId = ++idCounter;
        idCounter++;
    }

    public Chat(ArrayList<Message> messageList, Contact contact) {
        this.messageList = messageList;
        this.contact = contact;
        chatId = ++idCounter;
        idCounter++;
    }

    public Chat(ArrayList<Message> messageList, Contact contact, int backgroundId) {
        this.messageList = messageList;
        this.contact = contact;
        this.backgroundId = backgroundId;
        chatId = ++idCounter;
        idCounter++;
    }

    //-------------------------Methods:-----------------------

    @Override
    public String toString() {
        return "Chat{" +
                "messageList=" + messageList +
                ", contact=" + contact +
                ", backgroundId=" + backgroundId +
                ", chatId=" + chatId +
                '}';
    }

    public void addMessage(Message message){
        messageList.add(message);
    }


    //-------------------getter and setter--------------------

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getChatId() {
        return chatId;
    }

//    public void setChatId(int chatId) {
//        this.chatId = chatId;
//    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Chat.idCounter = idCounter;
    }
}

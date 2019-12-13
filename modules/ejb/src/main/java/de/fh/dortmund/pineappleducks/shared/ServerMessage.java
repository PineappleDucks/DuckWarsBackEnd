package de.fh.dortmund.pineappleducks.shared;

import java.util.Arrays;

public class ServerMessage extends Message {

    private Message[] dialogOptions;

    //---------------------Constructors:-----------------------

    public ServerMessage() {
        super();
    }

    public ServerMessage(String text, String date, Contact author, Message[] dialogOptions) {
        super(text, date, author);
        this.dialogOptions = dialogOptions;
    }

    public ServerMessage(String text, String date, Contact author) {
        super(text, date, author);
    }

    //-------------------------Methods:-----------------------

    @Override
    public String toString() {
        return "SERVERMESSAGE{" +
                ", text='" + super.getText() + '\'' +
                ", date='" + super.getDate() + '\'' +
                ", messageId=" + super.getMessageId() +
                ", author=" + super.getAuthor().toString() +
                "dialogOptions=" + Arrays.toString(dialogOptions) +
                '}';
    }


    //-------------------getter and setter--------------------

    public Message[] getDialogOptions() {
        return dialogOptions;
    }

    public void setDialogOptions(Message[] dialogOptions) {
        this.dialogOptions = dialogOptions;
    }
}

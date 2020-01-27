package entity.chat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @ManyToOne
    private Contact author;

    private String text;
    private Date date;

    @OneToMany
    private List<DialogOption> dialogOptions;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Contact getAuthor() {
        return author;
    }

    public void setAuthor(Contact author) {
        this.author = author;
    }

    public List<DialogOption> getDialogOptions() {
        return dialogOptions;
    }

    public void setDialogOptions(List<DialogOption> dialogOptions) {
        this.dialogOptions = dialogOptions;
    }
}

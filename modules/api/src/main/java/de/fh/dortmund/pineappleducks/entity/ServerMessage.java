package de.fh.dortmund.pineappleducks.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ServerMessage extends Message {

    @ManyToMany(targetEntity = Message.class)
    private List<Message> dialogOptions;

    public List<Message> getDialogOptions() {
        return dialogOptions;
    }

    public void setDialogOptions(List<Message> dialogOptions) {
        this.dialogOptions = dialogOptions;
    }
}

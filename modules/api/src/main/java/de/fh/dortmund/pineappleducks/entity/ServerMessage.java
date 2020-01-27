package de.fh.dortmund.pineappleducks.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

public class ServerMessage extends Message {

    @OneToMany
    private List<Message> dialogOptions;

    public List<Message> getDialogOptions() {
        return dialogOptions;
    }

    //public void List

    public void setDialogOptions(List<Message> dialogOptions) {
        this.dialogOptions = dialogOptions;
    }

}

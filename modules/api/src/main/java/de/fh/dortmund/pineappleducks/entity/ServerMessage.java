package de.fh.dortmund.pineappleducks.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

public class ServerMessage extends Message {

    private List<Message> dialogOptions;
}

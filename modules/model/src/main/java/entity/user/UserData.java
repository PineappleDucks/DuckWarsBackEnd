package entity.user;

import entity.chat.Chat;
import entity.chat.Condition;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Boolean helleseite;

    @OneToMany
    private List<Condition> conditions;

    @OneToMany
    private List<Chat> chats;

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public Boolean getHelleseite() {
        return helleseite;
    }

    public void setHelleseite(Boolean helleseite) {
        this.helleseite = helleseite;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}

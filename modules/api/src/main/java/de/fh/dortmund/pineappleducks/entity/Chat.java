package de.fh.dortmund.pineappleducks.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    private Contact contact;

    private List<Message> messageList;

    private Integer backgroundId;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Integer getBackgroundId() {
        return backgroundId;
    }

    public void setBackgroundId(Integer backgroundId) {
        this.backgroundId = backgroundId;
    }
}

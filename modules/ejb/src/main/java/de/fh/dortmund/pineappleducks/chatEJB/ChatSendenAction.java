package de.fh.dortmund.pineappleducks.chatEJB;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.entity.Chat;
import de.fh.dortmund.pineappleducks.manager.ChatManager;
import de.fh.dortmund.pineappleducks.shared.Message;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import java.io.Serializable;
import java.util.List;

public class ChatSendenAction implements Serializable, Action {
    private ChatManager manager;
    private Chat chat;

    public ChatSendenAction(Chat chat) {
        manager = new ChatManager();
        this.chat = chat;
    }

    @Override
    public void run() {
        de.fh.dortmund.pineappleducks.shared.Chat objectChat = manager.getChatByID(chat.getChatId());
        Message newMessage = new Message();
        objectChat.addMessage(newMessage);
        List<Message> listMessages = objectChat.getMessageList();
        Message latestMessage = listMessages.get(listMessages.size());
        ServerMessage antwort = manager.getAntwort((int) latestMessage.getNext());
    }
}
package de.fh.dortmund.pineappleducks.chatEJB;

import de.fh.dortmund.pineappleducks.manager.ChatManager;
import de.fh.dortmund.pineappleducks.shared.Message;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

public class Chat implements java.io.Serializable {
    private ChatManager manager;
    public Chat() {
    }

    public Message[] getOptions(int nachrichtID) {
        Message[] ret = manager.getServerMessageByID(nachrichtID).getDialogOptions();
        return ret;
    }

    public ServerMessage nachrichtSenden(int chatID, int antwortID) {
        de.fh.dortmund.pineappleducks.shared.Chat chat = manager.getChatByID(chatID);
        Message newMessage = new Message();
        chat.addMessage(newMessage);
        ServerMessage antwort = manager.getAntwort(antwortID);
        return antwort;
    }
}

package de.fh.dortmund.pineappleducks.chatEJB;

import de.fh.dortmund.pineappleducks.shared.Message;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

public class Chat implements java.io.Serializable {
    public Chat() {

    }

    public Message[] getOptions(int nachrichtID) {
        Message[] ret = new ServerMessage().getDialogOptions();
        return ret;
    }

    public ServerMessage nachrichtSenden(int chatID, int antwortID) {
        return new ServerMessage();
    }
}

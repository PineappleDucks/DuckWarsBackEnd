package de.fh.dortmund.pineappleducks.chatEJB;

import de.fh.dortmund.pineappleducks.action.Action;
import de.fh.dortmund.pineappleducks.entity.Chat;
import de.fh.dortmund.pineappleducks.manager.ChatManager;
import de.fh.dortmund.pineappleducks.shared.Message;

import java.util.List;

public class ChatOptionsAction implements Action {
    private final Chat chat;

    public ChatOptionsAction(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void run() {
        ChatManager manager = new ChatManager();
        de.fh.dortmund.pineappleducks.shared.Chat objectChat = manager.getChatByID(chat.getChatId());
        List<Message> listMessages = objectChat.getMessageList();
        Message message = listMessages.get(listMessages.size());
        int nachrichtID = message.getMessageId();
        Message[] ret = manager.getServerMessageByID(nachrichtID).getDialogOptions();

    }
}

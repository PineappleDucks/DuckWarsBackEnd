import com.fasterxml.jackson.databind.ObjectMapper;
import entity.InterfaceMessage;
import communication.ChatBean;
import entity.chat.DialogOption;
import entity.chat.Message;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    @EJB
    ChatBean chatBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        ObjectMapper mapper = new ObjectMapper();

        DialogOption reqMessage = mapper.readValue(req.getReader(), DialogOption.class);

        if(session != null){
            String username = (String)session.getAttribute("username");
            resp.setStatus(200);
            Message message = chatBean.messageSend(username, reqMessage);
            mapper.writeValue(resp.getWriter(), message);
        }else{
            resp.setStatus(401);
            InterfaceMessage message = new InterfaceMessage();
            message.setSuccessful(false);
            message.setMessage("Die Session ist ungueltig!");
            mapper.writeValue(resp.getWriter(), message);
        }
    }
}

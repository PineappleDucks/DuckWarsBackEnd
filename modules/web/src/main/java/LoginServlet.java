import com.fasterxml.jackson.databind.ObjectMapper;
import entity.InterfaceMessage;
import entity.user.Credential;
import communication.LoginBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    LoginBean loginBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Credential credential = mapper.readValue(req.getReader(), Credential.class);
        Boolean validCredentials = loginBean.checkForValidCredentials(credential);

        InterfaceMessage message = new InterfaceMessage();

        if(validCredentials){
            HttpSession session = req.getSession(true);
            session.setAttribute("username", credential.getUsername());
            String sessionId = session.getId();

            message.setToken(sessionId);
            message.setSuccessful(true);
            resp.setStatus(200);
            message.setMessage("Login erfolgreich!");
        }else{
            message.setSuccessful(false);
            resp.setStatus(401);
            message.setMessage("Die Nutzerdaten sind nicht korrekt!");
        }

        mapper.writeValue(resp.getWriter(), message);


    }
}

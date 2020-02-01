import com.fasterxml.jackson.databind.ObjectMapper;
import entity.InterfaceMessage;
import entity.user.RegisterCredential;
import communication.RegisterBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    RegisterBean registerBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        RegisterCredential credential = mapper.readValue(req.getReader(), RegisterCredential.class);

        InterfaceMessage message = registerBean.persist(credential);
        if(message.getSuccessful()){
            req.getSession(true);
            resp.setStatus(200);
            HttpSession session = req.getSession(true);
            session.setAttribute("username", credential.getUsername());
            String sessionId = session.getId();

            message.setToken(sessionId);
        } else {
            resp.setStatus(401);
        }

        mapper.writeValue(resp.getWriter(), message);
    }
}

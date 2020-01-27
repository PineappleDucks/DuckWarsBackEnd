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
import java.io.IOException;

@WebServlet("/communication")
public class RegisterServlet extends HttpServlet {

    @EJB
    RegisterBean registerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        RegisterCredential credential = mapper.readValue(req.getReader(), RegisterCredential.class);

        InterfaceMessage message = registerBean.persist(credential);
        if(message.getSuccessful()){
            req.getSession(true);
        }
    }
}

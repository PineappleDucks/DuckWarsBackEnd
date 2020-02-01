import com.fasterxml.jackson.databind.ObjectMapper;
import entity.InterfaceMessage;
import entity.user.UserData;
import communication.InitBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @EJB
    InitBean initBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ObjectMapper mapper = new ObjectMapper();

        if(session != null){
            resp.setStatus(200);
            UserData data = initBean.getUserData(req.getHeader("username"));
            mapper.writeValue(resp.getWriter(), data);
        }else{
            resp.setStatus(401);
            InterfaceMessage message = new InterfaceMessage();
            message.setSuccessful(false);
            message.setMessage("Die Session ist ungueltig!");
            mapper.writeValue(resp.getWriter(), message);
        }
    }
}

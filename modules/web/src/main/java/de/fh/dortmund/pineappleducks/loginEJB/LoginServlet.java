package de.fh.dortmund.pineappleducks.login;

        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    LoginBeanLocal loginBeanLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        //String login = req.getParameter("login");
        //String password = req.getParameter("password");
        writer.print(loginBeanLocal.persist("hallo", "hallo"));
    }
}
package de.fh.dortmund.pineappleducks.register;

import com.google.gson.Gson;
import de.fh.dortmund.pineappleducks.loginEJB.Login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // get params
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        // new login class
        Login login = new Login(username, password);

        // check login
        if (!login.checkName()) {
            // username not used

            // register
            login.register();

            // new gson class for output
            Gson gson = new Gson();

            // get writer
            PrintWriter out = resp.getWriter();

            // set output metadata
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            // print output
            out.print("register correct");
            out.flush();
        } else {
            // username is used

            // get writer
            PrintWriter out = resp.getWriter();

            // set output metadata
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(403);

            // print output
            out.print("username in use");
            out.flush();

        }
    }
}

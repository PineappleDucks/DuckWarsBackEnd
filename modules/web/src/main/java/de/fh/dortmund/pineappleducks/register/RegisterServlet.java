package de.fh.dortmund.pineappleducks.register;

import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    RegisterBeanLocal registerBeanLocal;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        if (registerBeanLocal.checkForExistingUserName(username) == Boolean.FALSE) {
            registerBeanLocal.persist(username, password);
            Gson gson = new Gson();
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print("register correct");
            out.flush();
        } else {
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(403);
            out.print("username in use");
            out.flush();

        }
    }
}

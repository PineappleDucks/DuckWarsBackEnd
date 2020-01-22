package de.fh.dortmund.pineappleducks.loginEJB;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // get params
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        // new login class
        Login login = new Login(username, password);

        // check login
        if (login.checkLogin()) {
            // login correct

            // new gson class for output
            Gson gson = new Gson();

            // get writer
            PrintWriter out = resp.getWriter();

            // set output metadata
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            // print output
            out.print("login correct");
            out.flush();
        } else {
            // login wrong

            // get writer
            PrintWriter out = resp.getWriter();

            // set output metadata
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(403);

            // print output
            out.print("wrong login");
            out.flush();
        }
    }
}
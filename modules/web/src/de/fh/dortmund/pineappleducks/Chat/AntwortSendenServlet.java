package de.fh.dortmund.pineappleducks.Chat;

import Chat.Nachricht;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/AntwortSenden")
public class AntwortSendenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        // check session
        // int AntwortID = req.getParameter("AntwortId");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        Nachricht nachr = new Nachricht();
        out.print(nachr.toString());
    }

}
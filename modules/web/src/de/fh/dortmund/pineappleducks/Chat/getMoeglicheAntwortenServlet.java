package de.fh.dortmund.pineappleducks.Chat;

import Chat.Antwort;
import Chat.Nachricht;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/getAntworten")
public class getMoeglicheAntwortenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // check session
        //int nachrichtID = req.getParameter("NachrichtId");
        Nachricht nachr = new Nachricht();
        List<Antwort> ant = nachr.getMoeglicheAntworten();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        for (Antwort a : ant) {
            out.print(a.toString());
        }
    }

}
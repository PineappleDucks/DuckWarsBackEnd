package de.fh.dortmund.pineappleducks.chatEJB;

import de.fh.dortmund.pineappleducks.shared.Message;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getRequestURL());  http://localhost:8080/web/init
//        System.out.println(req.getRequestURI());  /web/init

        int nachrichtID = parseInt(req.getParameter("NachrichtId"));
        Chat chat = new Chat();
        Message[] ant = chat.getOptions(nachrichtID);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        for (Message a : ant) {
            out.print(a.toString());
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int AntwortID = parseInt(req.getParameter("NachrichtId"));
        int ChatID = parseInt(req.getParameter("ChatID"));
        Chat chat = new Chat();
        ServerMessage nachr = chat.nachrichtSenden(ChatID, AntwortID);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        out.print(nachr.toString());
    }
}

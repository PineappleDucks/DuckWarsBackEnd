package de.fh.dortmund.pineappleducks.chatEJB;

import com.google.gson.Gson;
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

        int nachrichtID = parseInt(req.getParameter("NachrichtId"));
        Chat chat = new Chat();
        Gson gson = new Gson();
        String messageString;
        Message[] ant = chat.getOptions(nachrichtID);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print("<messages>");
        for (Message a : ant) {
            messageString = gson.toJson(a.toString());
            out.print(messageString);
        }
        out.print("</messages>");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int AntwortID = parseInt(req.getParameter("NachrichtId"));
        int ChatID = parseInt(req.getParameter("ChatID"));
        Chat chat = new Chat();
        Gson gson = new Gson();
        ServerMessage nachr = chat.nachrichtSenden(ChatID, AntwortID);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String nachrString = gson.toJson(nachr);
        out.print(nachrString);
    }
}

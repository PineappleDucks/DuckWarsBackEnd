package de.fh.dortmund.pineappleducks.chatEJB;

import com.google.gson.Gson;
import de.fh.dortmund.pineappleducks.shared.Message;
import de.fh.dortmund.pineappleducks.shared.ServerMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null){
            // fragt Antwort-Optionen für den Nutzer ab
            int messageId = parseInt(req.getParameter("messageId"));
            Chat chat = new Chat();
            Gson gson = new Gson();
            Message[] ant = chat.getOptions(messageId); // get mögliche Antworten

            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            out.print(gson.toJson(ant));

            out.flush();
        }else{
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(403);
            out.print("unauthorized");
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session != null) {
            // schickt Antwort des Nutzers, erhält Antwort des Servers zurück
            int messageId = parseInt(req.getParameter("messageId"));
            int chatId = parseInt(req.getParameter("chatId"));
            Chat chat = new Chat();
            Gson gson = new Gson();
            ServerMessage messages = chat.nachrichtSenden(chatId, messageId);

            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            out.print(gson.toJson(messages));

            out.flush();
        }else{
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(403);
            out.print("unauthorized");
            out.flush();
        }
    }
}

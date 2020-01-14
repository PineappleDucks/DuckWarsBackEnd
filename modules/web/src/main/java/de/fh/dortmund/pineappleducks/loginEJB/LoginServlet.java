package de.fh.dortmund.pineappleducks.loginEJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Class Resp{
        String id;
        Date created;
        String userId;
                    public Resp(String id, String user){
            created = new Date();
            created = created.getTime();
            this.id = id;
            userId = user;
        }
    }
    int respId = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Login login = new Login(username, password);
        if(login.checkName()==true){
            System.err.println("Fehler, der Name "+username+" ist schon vergeben");
        }
        else{
         login.register();
            Resp resp = new Resp(Integer.toString(respId), username)
                    respId++;
            try {
                Gson gson = new Gson();
                String loginString = gson.toJson(resp);
                PrintWriter out = resp.getWriter();
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(loginString);
                out.flush();
            } catch (ConstructException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        Login login = new Login(username, password);
        if (login.checkLogin() == true) {
            Resp resp = new Resp(Integer.toString(respId), username)
            respId++;
            try {
                Gson gson = new Gson();
                String loginString = gson.toJson(resp);
                PrintWriter out = resp.getWriter();
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(loginString);
                out.flush();
            } catch (ConstructException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
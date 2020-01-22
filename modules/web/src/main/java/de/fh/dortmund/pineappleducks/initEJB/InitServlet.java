package de.fh.dortmund.pineappleducks.initEJB;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import com.google.gson.*;


@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @EJB
    Init init;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {


        try {
            init.use(dequery(req.getQueryString()));
            Gson gson = new Gson();
            String initString = gson.toJson(init);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(initString);
            out.flush();
        }
//        when user not found: set status to 404 and send error message
        catch (ConstructException e){
            System.err.println(e.getMessage());
            PrintWriter out = resp.getWriter();
            resp.setStatus(404);
            out.print("User could not be found!");
        }
}
        //Method to seperate the keys and values of the get-method in a LinkedHashMap
        //Bsp.: hello=halli&key2=value2&key3=value3
    private LinkedHashMap dequery(String query){
        LinkedHashMap map = new LinkedHashMap();
        try {
            if (query.isEmpty()) {
                return map;
            } else {
                String[] keySplit = query.split("&");
//            System.out.println(keySplit.toString());
                String[][] kva;

                for (String s : keySplit) {
                    String[] kvSplit = s.split("=");
                    String k = kvSplit[0];
                    String v = kvSplit[1];
                    map.put(k, v);
                }
                return map;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.err.println("Anfrage enthaelt Fehler! Anfrage:"+query);
        }
        finally {
            return map;
        }
    }


}


package de.fh.dortmund.pineappleducks.initEJB;

import javax.servlet.ServletException;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getRequestURL());  http://localhost:8080/web/init
//        System.out.println(req.getRequestURI());  /web/init

        try {
            Init init = new Init(dequery(req.getQueryString()));
            Gson gson = new Gson();
            String initString = gson.toJson(init);
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            out.print(initString);
            out.flush();
        }
        catch (ConstructException e){
            System.err.println(e.getMessage());
        }
}
        //Method to seperate the keys and values of the get-method in a LinkedHashMap
        //hello=halli&key2=value2&key3=value3
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
//                System.out.println("Key: " + k + " Value: " + v);
                    map.put(k, v);
                }
//            System.out.println(map.toString());
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


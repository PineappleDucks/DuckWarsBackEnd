package de.fh.dortmund.pineappleducks.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import de.fh.dortmund.pineappleducks.model.User;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("TEST");
            EntityManager man = factory.createEntityManager();
            User user = new User();
            user.setUsername("test");
            user.setPassword("123");

            man.getTransaction().begin();
            man.persist(user);
            man.getTransaction().commit();

            Query query = man.createQuery("SELECT u FROM User u");
            List<User> list = query.getResultList();

            for(User user2 : list){
               PrintWriter writer = resp.getWriter();
               writer.println(user2.getUsername());
               writer.flush();
            }

            man.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


package servlet;


import com.model.HibernateToDoListDAO;
import com.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserManagement/")


public class UserManagement extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email"), password = request.getParameter("password");
        HttpSession sess = request.getSession(true);
        RequestDispatcher dispatcher = null;

        Users user = new Users();

        user.setEmailAddress(email);
        user.setPassword(password);

        try {
            user = HibernateToDoListDAO.getInstance().signIn(user);

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            try {
                request.getRequestDispatcher("../Error.jsp").forward(request, response);
            } catch (Exception e2) {}
        }


        response.setContentType("text/html");
        dispatcher = getServletContext().getRequestDispatcher("/TaskManagement/");
        sess.setAttribute("sessionUser", user);
        dispatcher.forward(request, response);


    }
}
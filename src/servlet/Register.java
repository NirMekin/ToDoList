package servlet;

import com.model.HibernateToDoListDAO;
import com.model.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tomerktzv on 05/03/2018.
 */

@WebServlet("/Register/")

public class Register extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String phone = request.getParameter("phone");

        Users user = new Users(firstName, lastName, phone, password, email);

        try {
            HibernateToDoListDAO.getInstance().register(user);
            request.getRequestDispatcher("../index.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            try {
                request.getRequestDispatcher("../Error.jsp").forward(request, response);
            } catch (Exception e2) {}
        }

    }
}

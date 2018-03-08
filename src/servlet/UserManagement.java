package servlet;


import com.model.HibernateToDoListDAO;
import com.model.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserManagement/")


public class UserManagement extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email"),
                password = request.getParameter("password");

        Users user = new Users();

        user.setEmailAddress(email);
        user.setPassword(password);

        try {
            HibernateToDoListDAO.getInstance().signIn(user);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            try {
                request.getRequestDispatcher("../Error.jsp").forward(request, response);
            } catch (Exception e2) {}
        }
    }
}
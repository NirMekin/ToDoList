package servlet;

import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/TaskManagement/")

public class TaskManagement extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession(true);
        Users currentUser = (Users)sess.getAttribute("sessionUser");
        RequestDispatcher dispatcher = null;

        System.out.println("got here!!!");
        request.setAttribute("username", currentUser.getFirstName());
        request.getServletContext().getRequestDispatcher("/task_management.jsp").forward(request, response);
    }


}

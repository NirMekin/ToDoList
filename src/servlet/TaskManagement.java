package servlet;

import com.model.HibernateToDoListDAO;
import com.model.Tasks;
import com.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/TaskManagement/")

public class TaskManagement extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession(true);
        Users currentUser = (Users)sess.getAttribute("sessionUser");
        RequestDispatcher dispatcher = null;
        String actionRequested = null;

        try {
            actionRequested = request.getParameter("taskManagement");
        } catch(Exception e) {
            System.out.println("No action");
        }

        if (actionRequested != null) {
            if (actionRequested.equals("create")) {
                Tasks task = new Tasks();
                task.setTaskName(request.getParameter("taskName"));
                task.setDescription(request.getParameter("taskDesc"));
                task.setUserId(currentUser.getId());
                try {
                    HibernateToDoListDAO.getInstance().createTask(task);
                } catch (com.model.exceptionsUsersTasks e) {
                    request.setAttribute("error", e.getMessage());
                    try {
                        request.getRequestDispatcher("../Error.jsp").forward(request, response);
                    } catch (Exception e2) {}
                }
            } else if (actionRequested.equals("delete")) {
                try {
                    HibernateToDoListDAO.getInstance().removeTask(request.getParameter("taskId"));
                } catch (com.model.exceptionsUsersTasks e) {
                    e.printStackTrace();
                }

            } else if (actionRequested.equals("editTask")) {
                try {
                    HibernateToDoListDAO.getInstance().editTask(request.getParameter("task_id"), request.getParameter("taskName"), request.getParameter("taskDesc"), request.getParameter("task_status"));
                } catch (com.model.exceptionsUsersTasks e) {
                    e.printStackTrace();
                }

            }
        }



        List<Tasks> tasks = null;

        try {
            tasks = HibernateToDoListDAO.getInstance().getTasks(currentUser);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        request.setAttribute("username", currentUser.getFirstName());
        request.setAttribute("tasks", tasks);
        request.getServletContext().getRequestDispatcher("/task_management.jsp").forward(request, response);
    }


}

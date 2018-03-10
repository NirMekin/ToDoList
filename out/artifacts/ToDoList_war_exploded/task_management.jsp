<%@ page import="com.model.Tasks" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
    h1 {
        text-align: center;
    }
    section {
        border: 2px solid black;
        border-radius: 20px;
        width: 200px;
        height: 200px;
        float: left;
        margin-bottom: 3px;
        margin-right: 3px;
    }
    .btn {
        margin: auto;
        display: block;
    }

    .editors {
        float: left;
        margin-left: 45px;
    }

    section > h3 {
        text-decoration: underline;
        text-align: center;
    }
</style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Task Management</title>

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>

</head>
<body>
    <h1>YOU ARE LOGGGED IN</h1>
    <h1>Welcome <%= request.getAttribute("username")%></h1>
    <%--<h3><a href=<%request.getAttribute("path");%>>Add New Task</a></h3>--%>
    <%--<h3><a href="../create_task.jsp">Add New Task</a></h3>--%>
    <h3>These are your tasks: </h3>
    <div class="container">
        <%
            List<Tasks> tasks = (List<Tasks>) request.getAttribute("tasks");
            if (tasks != null) {
                for(Tasks task : tasks) {
                    out.println("<section><h3># " + task.getTaskId() + "</h3><b>Task:</b>" + task.getTaskName() + "<br>");
                    out.println("<b>Description:</b> " + task.getDescription());
                    out.println("<br><b>Status: </b>" + task.getTaskCurrentStatus() + "<br><br>");
                    out.println("<form method=\"get\" action=\"/TaskManagement//\">");
                    out.println("<input type=\"hidden\" name=\"taskId\" value='" + task.getTaskId() + "'>");
                    out.println("<button type=\"submit\" class=\"btn btn-default mid btn-lg\" name=\"taskManagement\" value=\"delete\">\n" +
                            "  <span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>\n" +
                            "</button> </form></section>");
                }
            }
        %>
    </div>
    <div class="editors">
        <h2>Create a new task!</h2>
        <form method="get" action="/TaskManagement//">
            <div>
                Task Name: <input type="text" name="taskName" placeholder="name">
            </div>
            <div>
                Description: <input type="text" name="taskDesc">
            </div>
            <div>
                <input type="submit" name="taskManagement" value="create">
            </div>
        </form>
    </div>
    <%
        if (tasks != null) {
            out.println("<div class=\"editors\" style=\"display: block\">");
        } else {
            out.println("<div class=\"editors\" style=\"display: none\">");
        }
    %>
        <h2>Edit a task!</h2>
        <form method="get" action="/TaskManagement//">
            <div>
                <select name="task_id" class="selectpicker">
                    <%
                        if (tasks != null) {
                            for(Tasks task : tasks) {
                                out.println("<option value='" + task.getTaskId() + "'> " + task.getTaskId() +  " </option>");
                            }
                        }

                    %>
                </select>
            </div>
            <div>
                Task Name: <input type="text" name="taskName" placeholder="name">
            </div>
            <div>
                Description: <input type="text" name="taskDesc">
            </div>
            <div>
                <select name="task_status">
                    <option value="not_started">Not Started</option>
                    <option value="in_progress">In Progress</option>
                    <option value="done">Done</option>
                </select>
            </div>
            <div>
                <input type="submit" name="taskManagement" value="editTask">
            </div>
        </form>
    </div>
</body>
</html>

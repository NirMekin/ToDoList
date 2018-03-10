<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Task</title>
</head>
<style>
    h2 {
        text-align: center;
    }
</style>
<body>
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
</body>
</html>

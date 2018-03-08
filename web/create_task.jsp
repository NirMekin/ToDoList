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
            Email: <input type="text" name = "email" placeholder="email">
        </div>
        <div>
            Password: <input type="password" name = "password">
        </div>
        <div>
            <input type = "submit">
        </div>
        <div><h2>Don't have a user? <a href="register.jsp">Click Here</a></h2></div>
    </form>
</body>
</html>

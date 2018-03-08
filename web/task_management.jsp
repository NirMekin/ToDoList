<%--
  Created by IntelliJ IDEA.
  User: tomerktzv
  Date: 07/03/2018
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    h1 {
        text-align: center;
    }
</style>
<head>
    <title>Task Management</title>

</head>
<body>
    <h1>YOU ARE LOGGGED IN</h1>
    <h1>Welcome <%= request.getAttribute("username")%></h1>
    <h2>These are your tasks: </h2>
</body>
</html>

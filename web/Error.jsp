<%--
  Created by IntelliJ IDEA.
  User: tomerktzv
  Date: 05/03/2018
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <h1><%= request.getAttribute("error")%></h1>
    <a href="../index.jsp">Click here to go back to home page</a>
</head>
<body>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: tomerktzv
  Date: 05/03/2018
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1">

</head>
<body>
<div class="container">
    <form method="get" action="/Register//">
        <div>
            <h2>Please enter your details: </h2>
            Email: <input type="email" name = "email" placeholder="email">
        </div>
        <div>
            Password: <input type="password" name="password">
        </div>
        <div>
            First Name: <input type="text" name="first_name">
        </div>
        <div>
            Last Name: <input type="text" name="last_name">
        </div>
        <div>
            Phone: <input type="text" name="phone">
        </div>
        <div>
            <input type="submit">
        </div>
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/3/2019
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    request.getSession().getAttribute("loginMessage");
%>
<div class="container">
<form action="Login" method="post" class = "log">
    <h3>Login Page</h3>
    <b class="text-danger"> ${loginMessage}</b> <br/>
    <div class="form-group">
        <input type="text" name="user" placeholder="Username/Email" required />
    </div>
    <div class="form-group">
        <input type="password" name="password" placeholder="Password" required />
    </div>
    <input type="submit" class="btn btn-success" value="Login">
    <a href="forgotPassword.jsp" class="btn btn-link">Forgot Password</a>
</form>

<br>
<a href="/register.jsp" class="btn btn-default">Create Account</a>.
</div>

</body>
</html>

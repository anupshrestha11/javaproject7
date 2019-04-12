<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/12/2019
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forget Password</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    request.getSession().getAttribute("fMessage");
%>
<div class="container">

<form action="ForgotPassword" method="post">
    <h2>Forgot Password</h2><br>
    <b class="text-danger">${fMessage}</b>
    <div class="form-group">
        <input type="text" name="user" value="" placeholder="Enter Username/Email">
    </div>
    <input type="submit" value="Submit" class="btn btn-success">
</form>

</div>
</body>
</html>

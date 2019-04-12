<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/12/2019
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset Password</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="ResetPassword" method="post">
        <h3>Reset Password</h3>
        <b class="text-danger">${requestScope.rMessage}</b>
        <div class="form-group">
            <input type="password" name="newpwd" placeholder="New Password" />
        </div>
        <div class="form-group">
            <input type="password" name="renewpwd" placeholder="Re-enter Password">
        </div>
        <input type="submit" value="Reset" class="btn btn-success">
    </form>
</div>

</body>
</html>

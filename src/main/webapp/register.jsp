<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/3/2019
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    request.getSession().getAttribute("message");
%>
<div class="container">

<h1 font-color="red">Registration Page</h1>
<form action="UserRegister" method="post">

    <b class="text-warning"> ${message}</b> <br/><br/>
    <div class="form-group">
    <input type="text" name="name" placeholder="Name" class="box" required /><br/><br/>
    </div>
    <div class="form-group">
    <input type="email" name="email" placeholder="Email" class="box" required /><br/><br/>
    </div>
    <div class="form-group">
    <input type="text" name="username" placeholder="Username" class="box" required /><br/><br/>
    </div>
    <div class="form-group">
    <input type="password" name="password" placeholder="Password" class="box" required minlength="6" /><br/><br/>
    </div>
    <div class="form-group">
    <input type="password" name="repassword" placeholder="Re-Password" class="box" required min="6" /><br/><br/>
    </div>


    <input type="submit" value="Submit" class="btn btn-success"/>
    <br>
    <br>
    Already have account <a href="/login.jsp" class="btn btn-default">Login</a>



</form>
</div>
</body>
</html>

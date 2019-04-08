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
    <style>
        .box{
            width: 250px;
            height: 25px;
            text-align: center;
            font-weight: bold;
            border-width: 3px;

        }
        .btn
        {
            padding: 10px 15px;
            border-radius: 20px;
        }
    </style>
</head>
<body STYLE="text-align: center">
<%
    request.getSession().getAttribute("message");
%>

<script src="js/Script.js"></script>
<h1 font-color="red">Registration Page</h1>
<form action="UserRegister" method="post">

    <b style="color: red"> ${message}</b> <br/><br/>

    <input type="text" name="name" placeholder="Name" class="box" required /><br/><br/>
    <input type="email" name="email" placeholder="Email" class="box" required /><br/><br/>
    <input type="text" name="username" placeholder="Username" class="box" required /><br/><br/>
    <input type="password" name="password" placeholder="Password" class="box" required minlength="6" /><br/><br/>
    <input type="password" name="repassword" placeholder="Re-Password" class="box" required min="6" /><br/><br/>

    <input type="submit" value="Submit" class="btn"/>
    <br>
    <br>
    OR
    <br>
    <br>
    Already hava account click <a href="/login.jsp">here</a>



</form>

</body>
</html>

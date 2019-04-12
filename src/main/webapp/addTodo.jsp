<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/8/2019
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate,no-reload");

    if (httpSession.getAttribute("Name")==null){
        response.sendRedirect("/login.jsp");
    }
%>
<div class="container">
    <a href="/welcome.jsp" class="left-arrow-button">Home Page</a>
    <a href="ShowTodo" class="right-arrow-button">Show Todo</a>
<form action="AddTodo" method="post">
    <br><br>
    <input type="text" name="desc" width="300px" placeholder="Description" class="form-control"><br>
    <input type="date" name="targetDate" placeholder="TargetDate" class="form-control"><br>
    <input type="submit" value="Submit" class="btn btn-success">
</form>
</div>
</body>
</html>

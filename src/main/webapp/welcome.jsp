<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/3/2019
  Time: 8:20 PM
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


    <form action="Logout" method="get">
        <h4>Welcome ${Name}</h4>
        <a href="/addTodo.jsp" class="btn btn-group">Add Todo</a>
        <a href="ShowTodo" class="btn btn-group" >Show Todo</a> <br><br>
        <input type="submit" value="Logout" class="btn btn-warning"/>
    </form>
</div>
</body>
</html>

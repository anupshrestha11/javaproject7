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
</head>
<body>
<%
    HttpSession httpSession = request.getSession();

    if (httpSession.getAttribute("Name")==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
%>
Welcome ${Name}

<form action="Logout" method="get">
    <input type="submit" value="Logout" />
</form>

<a href="/addTodo.jsp">add todo</a>
<a href="ShowTodo">Show todo</a>

</body>
</html>

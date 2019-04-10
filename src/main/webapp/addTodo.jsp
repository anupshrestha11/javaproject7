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
</head>
<body>
<%
    HttpSession httpSession = request.getSession();

    if (httpSession.getAttribute("Name")==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
%>
<form action="AddTodo" method="post">
    <input type="text" name="desc" width="300px" placeholder="Description">
    <input type="date" name="targetDate" placeholder="TargetDate" DATAFORMATAS="yyyy/mm/dd" id="">
    <input type="submit" value="Submit">
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/7/2019
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();

    if (httpSession.getAttribute("LoggedIn")==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
%>
<table>
    <thead>
    <th>S.N.</th>
    <th>Todo</th>
    <th>Is Done?</th>
    <th>Created Date</th>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.todos}" var="todo" varStatus="i">
        <tr>
            <td><c:out value="${i.index+1}"></c:out> </td>
            <td><c:out value="${todo.name}"></c:out> </td>
            <td><c:out value="${todo.done}"></c:out> </td>
            <td><c:out value="${todo.date}"></c:out> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

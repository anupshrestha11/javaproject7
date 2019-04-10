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
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    HttpSession httpSession = request.getSession();

    if (httpSession.getAttribute("Name")==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    httpSession.getAttribute("todos");


%>


<div class="container">
<h2>Your Todo LIst</h2>
<table class="table table-striped">
    <caption><h3>Todo List</h3></caption>
    <thead>
    <th>S.N.</th>
    <th>Todo</th>
    <th>Is Done?</th>
    <th>Target Date</th>
    <th>Days Left</th>
    <th></th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo" varStatus="i">
        <tr>
            <td><c:out value="${i.index+1}"></c:out> </td>
            <td><c:out value="${todo.desc}"></c:out> </td>
            <td><c:out value="${todo.done}"></c:out> </td>
            <td><c:out value="${todo.targetDate}"></c:out> </td>
            <td><c:out value="${todo.days}"></c:out></td>
            <td><a type="button" class="btn btn-success" value="Update" href="UpdateTodo?id=${todo.id}">Update</a></td>
            <td><a type="button" class="btn btn-warning" value="Delete" href="DeleteTodo?id=${todo.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/addTodo.jsp" class="button">Add Todo</a>
</div>
</body>
</html>

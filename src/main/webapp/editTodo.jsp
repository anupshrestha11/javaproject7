<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/10/2019
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Todo</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate,no-reload");

    if (httpSession.getAttribute("Name")==null){
        response.sendRedirect("/login.jsp");
    }
    httpSession.getAttribute("tododata");
%>
<div class="container">
    <a href="/welcome.jsp" class="left-arrow-button">Home Page</a>
    <a href="ShowTodo" class="right-arrow-button">Show Todo</a>
<form action="UpdateTodo?id=<c:out value="${tododata.id}"></c:out>" method="post">
    <input type="text" name="desc" placeholder="Enter Description" class="form-control" value="<c:out value="${tododata.desc}"></c:out>" /><br/>
    <div class="radio">
        <input type="radio" name="isdone"   value="true"  <c:if test="${tododata.done == true }"> checked </c:if> />Done <br />
    </div>
    <div class="radio">
        <input type="radio" name="isdone"   value="false"  <c:if test="${tododata.done == false}" > checked </c:if> />Not-Done <br />
    </div>
    <input type="date" name="targetdate" class="form-control" value="<c:out value="${tododata.targetDate}"></c:out>" /><br/>
    <input type="submit" class="btn btn-success">
</form>
</div>

</body>
</html>

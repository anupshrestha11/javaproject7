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
</head>
<body>
<%
    HttpSession httpSession = request.getSession();


    if (httpSession.getAttribute("Name")==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    httpSession.getAttribute("tododata");
%>

<form action="UpdateTodo?id=<c:out value="${tododata.id}"></c:out>" method="post">
    <input type="text" name="desc" placeholder="Enter Description" value="<c:out value="${tododata.desc}"></c:out>" /><br/><br/>

    <input type="radio" name="isdone"   value="true"  <c:if test="${tododata.done == true }"> checked </c:if> />Done <br />
    <input type="radio" name="isdone"   value="false"  <c:if test="${tododata.done == false}" > checked </c:if> />Not-Done <br />

    <input type="date" name="targetdate" value="<c:out value="${tododata.targetDate}"></c:out>" /><br/>
    <input type="submit">
</form>

</body>
</html>

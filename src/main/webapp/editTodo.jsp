<%@include file="header.jsp" %>
<%@include file="session.jsp" %>
<%
    httpSession.getAttribute("tododata");
%>
<div class="container">
    <%@include file="element.jsp" %>

    <form action="UpdateTodo?id=<c:out value="${tododata.id}"></c:out>" method="post">
        <input type="text" name="desc" placeholder="Enter Description" class="form-control"
               value="<c:out value="${tododata.desc}"></c:out>" required/><br/>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="isdone" autocomplete="off" value="true"  <c:if
                        test="${tododata.done == true }"> checked </c:if> />Done
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="isdone" autocomplete="off" value="false"  <c:if
                        test="${tododata.done == false}"> checked </c:if> />Not-Done
            </label>
        </div>
        <br><br>
        <input type="date" name="targetdate" class="form-control" value="<c:out value="${tododata.targetDate}"></c:out>"
               required/><br/>
        <input type="submit" value="update" class="btn btn-success">
    </form>
</div>

</body>
</html>

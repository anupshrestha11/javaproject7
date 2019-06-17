<%@include file="header.jsp" %>
<%@include file="session.jsp" %>
<%
    httpSession.getAttribute("todos");
%>

<div class="container">
    <div class="row">
        <div class="col">
            <%@include file="element.jsp" %>
        </div>
    </div>

    <%@include file="addTodo.jsp" %>
    <caption><h3>Todo List</h3></caption>

    <table class="table table-striped">
        <thead>
        <th>S.N.</th>
        <th>Todo</th>
        <th>Is Done?</th>
        <th>Target Date</th>
        <th>Days Left</th>
        <th></th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo" varStatus="i">

            <tr
                    <c:if test="${todo.done==false && todo.days le 0}"> class="bg-danger "</c:if>
                    <c:if test="${todo.done==false && todo.days le 10}"> class="bg-warning "</c:if>
            >
                <td><c:out value="${i.index+1}"></c:out></td>
                <td><c:out value="${todo.desc}"></c:out></td>
                <td><c:out value="${todo.done}"></c:out></td>
                <td><c:out value="${todo.targetDate}"></c:out></td>
                <td><c:out value="${todo.days}"></c:out></td>
                <td>
                    <a href="IsDone?id=${todo.id}&isDone=true" type="button" class="btn btn-success">Done</a>
                    <a href="IsDone?id=${todo.id}&isDone=false" type="button" class="btn btn-success">Not-Done</a>
                </td>
                <td><a type="button" class="btn btn-outline-warning font-weight-bold" value="Update"
                       href="UpdateTodo?id=${todo.id}">Edit</a>
                </td>
                <td><a type="button" class="btn btn-outline-danger font-weight-bold" value="Delete"
                       href="DeleteTodo?id=${todo.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="DeleteAllTodo" class="btn btn-outline-danger">Delete All Todo</a>

</div>
</body>
</html>

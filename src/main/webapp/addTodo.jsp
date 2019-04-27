<%--<%@include file="header.jsp"%>--%>
<%--<%@include file="session.jsp"%>--%>
<div class="container">
    <%--<%@include file="element.jsp"%>--%>
    <form action="AddTodo" method="post" class="form">
        <div class="row">
            <div class="col">
                <%--<label>Todo</label>--%>
                <input type="text" name="desc" width="300px" placeholder="Description" class="form-control" required>
            </div>
            <div class="col">
                <%--<label>Target Date</label>--%>
                <input type="date" name="targetDate" placeholder="TargetDate" class="form-control date-picker" required>

            </div>
            <div class="col">
                <input type="submit" value="Add Todo" class="btn btn-success">
            </div>
        </div>
    </form>
</div>
<%--</body>--%>
<%--</html>--%>

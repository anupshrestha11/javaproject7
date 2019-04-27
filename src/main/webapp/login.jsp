<%@include file="header.jsp" %>
<%
    request.getSession().getAttribute("loginMessage");
%>
<div class="container">
    <form action="Login" method="post" class="log">
        <br><h3>Login Page</h3>
        <b class="text-danger"> ${loginMessage}</b> <br/>
        <div class="form-group">
            <input type="text" name="user" placeholder="Username/Email" required/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Password" minlength="6" required/>
        </div>
        <input type="submit" class="btn btn-success" value="Login">
        <a href="forgotPassword.jsp" class="btn btn-link">Forgot Password</a>
    </form>

    <br>
    <a href="/register.jsp" class="btn btn-outline-primary">Create Account</a>.
</div>

</body>
</html>

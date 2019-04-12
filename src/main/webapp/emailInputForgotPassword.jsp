<%--
  Created by IntelliJ IDEA.
  User: Anup
  Date: 4/12/2019
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Code</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <form action="EmailCode" method="get">
        <h3>Enter Code</h3>
        <p>Code is sent to your registed Email Addres <br> Check your mail</p>
        <div class="form-group">
            <input type="text" name="pincode" />
        </div>
        <input type="submit" value="Submit" class="btn btn-success">
    </form>
</div>
</body>
</html>

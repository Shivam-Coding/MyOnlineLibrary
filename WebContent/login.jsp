<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<c:url value="/userLogin" var="loginURL"/>

<form action="${loginURL}"  method="post">
<c:if test="${param.error != null }">
<p>Invalid username or password</p>
</c:if>
<input name="username" value=""><br>
<input type="password" name="password"><br>
<input type="submit" name ="submit">

</form>

</body>
</html>
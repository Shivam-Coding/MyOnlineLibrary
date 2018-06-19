<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book</title>
</head>
<body>

<a href="logout">logout</a>

<form:form commandName="book" enctype="multipart/form-data">
Name:<form:input path="name"/><form:errors path="name"/><br>
Pages:<form:input path="pages"/><form:errors path="pages"/><br>
<form:hidden path="type"/>
Author:<form:input path="author"/><form:errors path="author"/><br>
Subject:<form:input path="subject"/><form:errors path="subject"/><br>
Publication:<form:input path = "publication"/><form:errors path="publication"/><br>
File:<form:input type="file" path="file"/><form:errors path="file"/><br>
<input type="submit" name="submit">

</form:form>

</body>
</html>
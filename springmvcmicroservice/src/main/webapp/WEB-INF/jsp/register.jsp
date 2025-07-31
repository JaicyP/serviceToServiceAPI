<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is the register page</h1>
<form action="${pageContext.request.contextPath}/registerEmployee" method="post">
<label>Id:</label>
<input type="text" name="id"><br/>
<label>Name:</label>
<input type="text" name="name"><br/>
<label>Email:</label>
<input type="text" name="email"><br/>
<label>Department:</label>
<input type="text" name="department"><br/>
<input type="submit">
</form>
</body>
</html>
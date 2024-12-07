<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>UPDATE DETAILS...</h1>
<form action="update">
      <pre>
      ID         : <input type="text" name="id" value="${courses.id}"> <br>
      COURSENAME : <input type="text" name="courseName" value="${courses.courseName}"> <br>
      FEE        : <input type="text" name="fee" value="${courses.fee}"> <br>
      USERNAME   : <input type="text" name="username" value="${courses.username}"> <br> 
      PASSWORD   : <input type="text" name="password" value="${courses.password}"> <br>
      <input type="submit" value="UPDATE">
      </pre>
      </form>
</body>
</html>
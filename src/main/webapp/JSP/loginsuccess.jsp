<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function deleteCourse()
{
  document.fn.action="delete";
  document.fn.submit();
}

function editCourse()
{
	document.fn.action="edit";
	document.fn.submit();
}
</script>
</head>
<body>
<h1>Login Success....</h1>
<form name="fn">
 <table border="1">
  <tr>
   <th>SELECT</th>
   <th>ID</th>
   <th>COURSENAME</th>
   <th>FEE</th>
   <th>USERNAME</th>
   <th colspan="2">ACTION</th>
  </tr>
  
  <c:forEach items="${courseList}" var="c">
   <tr>
   <td><input type="radio" name="id" value="${c.id}"></td>
   <td>${c.id}</td>
   <td>${c.courseName}</td>
   <td>${c.fee}</td>
   <td>${c.username}</td>
   <td><input type="button" value="EDIT" onclick="editCourse()"></td>
   <td><input type="button" value="DELETE" onclick="deleteCourse()"></td>
   </tr>
  </c:forEach>
 </table>
</form>
</body>
</html>
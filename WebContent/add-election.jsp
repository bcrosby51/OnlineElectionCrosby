<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Election</title>
</head>
<body>
<form action="AddElectionServlet" method="post">
<table border=1 cellpadding=5>
	<tr>
		<td>Election Name: <input type= "text" name="electName"></td>
	</tr>
	<tr>
		<td>Candidate One: <input type= "text" name="candOne"></td>
	</tr>
	<tr>
		<td>Candidate Two: <input type= "text" name="candTwo"></td>
	</tr>
	<tr>
		<td>Candidate Three: <input type= "text" name="candThree"></td>
	</tr>
</table>

<input type = "submit" name="addElectionChoice" value= "Create Election">
<input type = "submit" name="addElectionChoice" value= "Cancel New Election">
</form>
</body>
</html>
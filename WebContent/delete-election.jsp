<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Selected Item</title>
</head>
<body>
<%
String tempElection = (String)request.getAttribute("tempElectName");
%>
<form action = "deleteElectionServlet" method = "post">
Election to Delete:<input type= "text" name="electToDelete" value="<%=tempElection%>">

<input type = "submit" name="deleteElectionChoice" value= "Delete Election">
<input type = "submit" name="deleteElectionChoice" value= "Cancel Delete Election">

</form>
</body>
</html>
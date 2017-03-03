<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.ArrayList, model.ListElection" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election List</title>
</head>
<body>
<% ArrayList<ListElection> allElectionsList = (ArrayList<ListElection>)request.getAttribute("AllElectionsList");

%>
	<form method="post" action="MasterElectionServlet">
		<table border=1 cellpadding=5>
			<tr>
				<th>Select</th>
				<th>Election Name</th>
				<th>Candidate One</th>
				<th>Candidate Two</th>
				<th>Candidate Three</th>
			</tr>
			<%
				for (int i = 0; i < allElectionsList.size(); i++) {
			%>
			<tr>
				<td><input type = "radio" name="id" value="<%=i %>"></td>
				<td><%=allElectionsList.get(i).getElectionName()%></td>
				<td><%=allElectionsList.get(i).getCanidName1()%></td>
				<td><%=allElectionsList.get(i).getCanidName2()%></td>
				<td><%=allElectionsList.get(i).getCanidName3()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<input type= "submit" name="doThisToElection" value="Start Election">
		<input type= "submit" name="doThisToElection" value="Create Election">
		<input type= "submit" name="doThisToElection" value="Delete Election">
		<input type= "submit" name="doThisToElection" value="View Results">
	</form>

</body>
</html>
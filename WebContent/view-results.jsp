<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.ArrayList, model.ListElection" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election Results</title>
</head>
<body>
<% ArrayList<ListElection> allElectionsList = (ArrayList<ListElection>)request.getAttribute("AllElectionsList");

%>
	<form method="post" action="ViewResultsServlet">			
			<%
				for (int i = 0; i < allElectionsList.size(); i++) {
			%>
			<table border=1 cellpadding=5 border-collapse=separate border-spacing=2px border-color=gray;>
				<tr>
					<th>Election Name</th>
					<td><%=allElectionsList.get(i).getElectionName()%></td>
				</tr>
				<tr>
					<th>Candidate</th>
					<th>Results</th>
				</tr>
				<tr>
					<td><%=allElectionsList.get(i).getCanidName1()%></td>
					<td><%=allElectionsList.get(i).getCanidVote1()%></td>
				</tr>
				<tr>
					<td><%=allElectionsList.get(i).getCanidName2()%></td>
					<td><%=allElectionsList.get(i).getCanidVote2()%></td>
				</tr>
				<tr>
					<td><%=allElectionsList.get(i).getCanidName3()%></td>
					<td><%=allElectionsList.get(i).getCanidVote3()%></td>
				</tr>
				<br>
			</table>
			<%
				}
			%>
	
		<input type= "submit" name="doThisToElection" value="Back to Elections">
	</form>

</body>
</html>
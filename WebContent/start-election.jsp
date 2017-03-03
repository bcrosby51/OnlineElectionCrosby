<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="model.ListElection" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Voting</title>
</head>
<body>
<%
int currentElectionId = (int)request.getAttribute("electId");
String currentElection = (String)request.getAttribute("electName");
String currentCandidOne = (String)request.getAttribute("candidOneName");
String currentCandidTwo = (String)request.getAttribute("candidTwoName");
String currentCandidThree = (String)request.getAttribute("candidThreeName");
String currentCandidOneVote = (String)request.getAttribute("candidOneVote");
String currentCandidTwoVote = (String)request.getAttribute("candidTwoVote");
String currentCandidThreeVote = (String)request.getAttribute("candidThreeVote");
%>
<form method="post" action="VoteProcessingServlet">

<h2>Cast your vote for : <%=currentElection%></h2>

		<table border=1 cellpadding=5>
			<tr>
				<th>Select</th>
				<th>Candidate</th>
			</tr>
			<tr>
				<td><input type = "radio" name="id" value="1"></td>
				<td><%=currentCandidOne%></td>
			</tr>
			<tr>
				<td><input type = "radio" name="id" value="2"></td>
				<td><%=currentCandidTwo%></td>
			</tr>
			<tr>
				<td><input type = "radio" name="id" value="3"></td>
				<td><%=currentCandidThree%></td>
			</tr>
		</table>
		<input type= "submit" name="voteSelection" value="Cast Vote">
		<input type= "submit" name="voteSelection" value="Cancel Vote">
		<input type="hidden" name="electionName" value="<%=currentElection%>">
	</form>
</body>
</html>
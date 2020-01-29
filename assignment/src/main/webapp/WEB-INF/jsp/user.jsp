<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<center>
		<h1>User Data</h1>
		<form:form action="user.do" method="POST" commandName="user">
			<table>
				<tr>
					<td>ID</td>
					<td><form:input path="id" /></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><form:input path="status" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" name="action" value="Add" />
						<input type="submit" name="action" value="Edit" /> 
						<input type="submit" name="action" value="Delete" /> 
						<input type="submit" name="action" value="Search" />
					</td>
				</tr>
			</table>
		</form:form>
		<center>
			<h2>${message}</h2>
			<br>
			<br>
			<table border="1">
				<th width="30%" align="center">ID</th>
				<th width="30%" align="right">User Name</th>
				<th width="30%" align="right">Password</th>
				<th width="30%" align="center">Status</th>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td width="30%" align="center">${user.id}</td>
						<td width="30%" align="right">${user.username}</td>
						<td width="30%" align="right">${user.password}</td>
						<td width="30%" align="center">${user.status}</td>
					</tr>
				</c:forEach>
			</table>
		</center>
</body>
</html>
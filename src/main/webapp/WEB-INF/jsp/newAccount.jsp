<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="lbl.title" />
	</h1>
	<form:form action="saveAccount" modelAttribute="account" method="POST">
		<table>
			<tr>
				<td>Account#:</td>
				<td><form:input path="accountNo" size="30" /></td>
			</tr>
			<tr>
				<td>Account Holder Name:</td>
				<td><form:input path="accountHolderName" size="30" /></td>
			</tr>
			<tr>
				<td>Account Balance:</td>
				<td><form:input path="balance" size="30" /></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="Create Account"
					name="btnSubmit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
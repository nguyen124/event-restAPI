<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
<style>
.error {
	color: red
}
</style>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
</head>
<body>
	<div class="container">
		<h1>
			<spring:message code="lbl.title" />
		</h1>
		<form:form action="saveAccount" modelAttribute="account" method="POST">
			<table>
				<tr>
					<td><spring:message code="lbl.accountNo" /></td>
					<td><form:input path="accountNo" size="30" /> <form:errors
							path="accountNo" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="lbl.accountHolderName" /></td>
					<td><form:input path="accountHolderName" size="30" /> <form:errors
							path="accountHolderName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="lbl.balance" /></td>
					<td><form:input path="balance" size="30" /> <form:errors
							path="balance" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="lbl.dob" /></td>
					<td><form:input path="dob" size="30" /> <form:errors
							path="dob" cssClass="error" /></td>
				</tr>
				<tr>
					<td><spring:message code="lbl.psCode" /></td>
					<td><form:input path="psCode" size="30" /> <form:errors
							path="psCode" cssClass="error" /></td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${account.accountNo == null }">
							<td colspan="2"><input type="submit" value="Create"
								name="btnSubmit" /></td>
						</c:when>
						<c:otherwise>
							<td colspan="2"><input type="submit" value="Update"
								name="btnSubmit" /></td>
						</c:otherwise>
					</c:choose>

				</tr>
			</table>
		</form:form>
	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
</head>
<body>
	<div class="row">
		<div class="col-12">
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>
			<p class="display-5">
				Welcome: ${username}, <a href="javascript:formSubmit()">Logout</a>
			</p>
		</div>
	</div>
	<div class="container">
		<table border="1" width="100%">
			<thead>
				<tr>
					<th><spring:message code="lbl.accountNo"></spring:message></th>
					<th><spring:message code="lbl.accountHolderName"></spring:message></th>
					<th><spring:message code="lbl.balance"></spring:message></th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${accounts}">
					<c:url var="updateLink" value="/edit">
						<c:param name="accountNo" value="${account.accountNo}" />
					</c:url>
					<c:url var="deleteLink" value="/delete">
						<c:param name="accountNo" value="${account.accountNo}" />
					</c:url>
					<tr>
						<td>${account.accountNo}</td>
						<td>${account.accountHolderName}</td>
						<td>${account.balance}</td>
						<td><a href="${updateLink}">Edit</a></td>
						<td><a href="${deleteLink}"
							onClick="if(!(confirm('R U Sure to Delete?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
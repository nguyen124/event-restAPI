<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th><spring:message code="lbl.accountNo"></spring:message></th>
				<th><spring:message code="lbl.accountHolderName"></spring:message></th>
				<th><spring:message code="lbl.balance"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${accounts}">

				<tr>
					<td>${account.accountNo}</td>
					<td>${account.accountHolderName}</td>
					<td>${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Account details

	<%-- <p>Account#: ${param.accountNo }</p>
	<p>Account Holder#: ${param.accountHolderName}</p>
	<p>Account balance#: ${param.balance }</p> --%>
	<p>
		<spring:message code="lbl.accountNo" />
		#: ${account.accountNo}
	</p>
	<p>
		<spring:message code="lbl.accountHolderName" />
		#: ${account.accountHolderName}
	</p>
	<p>
		<spring:message code="lbl.balance" />
		#: ${account.balance}
	</p>
</body>
</html>
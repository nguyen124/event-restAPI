<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<p>Account#: ${account.accountNo}</p>
	<p>Account Holder#: ${account.accountHolderName}</p>
	<p>Account balance#: ${account.balance}</p>
</body>
</html>
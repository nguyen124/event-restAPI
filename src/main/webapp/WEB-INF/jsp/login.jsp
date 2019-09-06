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
	<div class="container">
		<div class="row">
			<div class="col-6 offset-3 align-self-center">
				<div class="card">
					<div class="card-header bg-info text-white">Please fill in
						username and passsword</div>
					<div class="card-body">

						<form role="form" method="post" action="<c:url value='/login'/>">
							<div class="form-group">
								<label for="Username">User name: </label> <input type="text"
									class="form-control" placeholder="Enter username"
									name="username" />
							</div>
							<div class="form-group">
								<label for="Password">Password: </label> <input type="password"
									class="form-control" placeholder="Password" name="password" />
							</div>

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="login"
								name="submit" class="btn btn-primary" />
						</form>
					</div>
				</div>
			</div>


			<div class="col-6 align-self-center mt-3">
				<c:if test="${not empty error}">
					<p class="alert-danger">${error}</p>
				</c:if>

				<c:if test="${not empty msg}">
					<p class="alert-warning">${msg}</p>
				</c:if>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
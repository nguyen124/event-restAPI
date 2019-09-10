<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>

<head>
<link href="<c:url value='static/css/app.css' />" rel="stylesheet"></link>

<%@ include file="/WEB-INF/jsp/header.jsp"%>
</head>

<body ng-app="myApp" class="ng-cloak">

	<div class="container">
		<h2 class="text-muted">Glegoo</h2>
	</div>

	<div class="container" ng-controller="UserController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="lead">User Registration Form</div>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.user.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="accountNo">Account
								Number</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.accountNo" id="accountNo"
									class="form-control input-sm"
									placeholder="Enter account number" required />

								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.accountNo.$error.required">This is a
										required field</div>
									<div ng-show="myForm.accountNo.$error.minlength">Minimum
										required is 3</div>
									<div ng-show="myForm.accountNo.$invalid">This field is
										valid</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="accountHolderName">Account
								Holder Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.accountHolderName"
									id="accountHolderName" class="form-control input-sm"
									placeholder="Enter your account name" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="balance">Account
								Balance</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.balance" id="balance"
									class="form-control input-sm" placeholder="Enter your balance"
									required />
								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.balance.$error.required">This is
										required field</div>
									<div ng-show="myForm.balance.$invalid">This is invalid
										value</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="dob">Date of
								Birth</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.dob" id="dob"
									class="form-control input-sm"
									placeholder="Enter your date of birth" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.dob.$error.required">This is
										required field</div>
									<div ng-show="myForm.dob.$invalid">This is invalid value</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="psCode">PS
								Code</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.psCode" id="psCode"
									class="form-control input-sm" placeholder="Enter your PS code"
									required />
								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.psCode.$error.required">This is
										required field</div>
									<div ng-show="myForm.psCode.$invalid">This is invalid
										value</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions col-md-12">
							<input type="submit" ng-model="ctrl.actionValue"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid" />
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>

				</form>
			</div>
		</div>

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<div class="lead">List of Users</div>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>AccountNo</th>
							<th>Account Holder</th>
							<th>Balance</th>
							<th>Date of Birth</th>
							<th>PS Code</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.users">
							<td><div ng-bind="u.accountNo"></div></td>
							<td><div ng-bind="u.accountHolderName"></div></td>
							<td><div ng-bind="u.balance"></div></td>
							<td><div ng-bind="u.dob"></div></td>
							<td><div ng-bind="u.psCode"></div></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.accountNo)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.accountNo)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="WEB-INF/jsp/footer.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.js"></script>
	<script src="<c:url value='static/js/app.js' />"></script>
	<script src="<c:url value='static/js/service/user_service.js' />"></script>
	<script src="<c:url value='static/js/controller/user_controller.js' />"></script>
</body>

</html>

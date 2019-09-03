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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body ng-app="myApp" class="ng-cloak">
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
							<label class="col-md-2 control-label" for="uname">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.username" id="uname"
									class="username form-control input-sm"
									placeholder="Enter your name" required ng-minlength="3" />

								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.uname.$error.required">This is a
										required field</div>
									<div ng-show="myForm.uname.$error.minlength">Minimum
										required is 3</div>
									<div ng-show="myForm.uname.$invalid">This field is valid</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="address">Address</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.user.address" id="address"
									class="form-control input-sm" placeholder="Enter your address" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label" for="email">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.user.email" id="email"
									class="email form-control input-sm"
									placeholder="Enter your email" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<div ng-show="myForm.email.$error.required">This is
										required field</div>
									<div ng-show="myForm.email.$invalid">This is invalid
										value</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions col-md-12">
							<input type="submit" value="{{!ctrl.user.id ? 'Add' : 'Update'}}"
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
							<th>ID.</th>
							<th>Name</th>
							<th>Address</th>
							<th>Email</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.users">
							<td><div ng-bind="u.id"></div></td>
							<td><div ng-bind="u.username"></div></td>
							<td><div ng-bind="u.address"></div></td>
							<td><div ng-bind="u.email"></div></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<h1>
		<spring:message code="lbl.title" />
	</h1>


	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/user_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/user_controller.js' />"></script>

</body>
</html>
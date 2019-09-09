'use strict';

(function(module) {
	var userService = function($http, $q) {

		var REST_SERVICE_URI = 'http://localhost:8080/MyApp/account/';

		var factory = {
			fetchAllUsers : fetchAllUsers,
			createUser : createUser,
			updateUser : updateUser,
			deleteUser : deleteUser
		};

		return factory;

		function fetchAllUsers() {
			var deferred = $q.defer();
			$http.get(REST_SERVICE_URI).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.log('Error while fetching users');
				deferred.reject(err);
			});
			return deferred.promise;
		}

		function createUser(user) {
			var deferred = $q.defer();
			$http.post(REST_SERVICE_URI, user).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.log('Error while creating users');
				deferred.reject(err);
			});

			return deferred.promise;
		}

		function updateUser(user, accountNo) {
			var deferred = $q.defer();
			$http.put(REST_SERVICE_URI + accountNo, user).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.log('Error while updating user');
				deferred.reject(err);
			});
			return deferred.promise;
		}

		function deleteUser(accountNo) {
			var deferred = $q.defer();
			$http.delete(REST_SERVICE_URI+accountNo).then(function(response){
				deferred.resolve(response.data);
			}, function(err){
				console.log('Error while deleting user');
				deferred.reject(err);
			});
			return deferred.promise;
		}
	};

	module.factory('UserService', userService);
}(angular.module('myApp')));
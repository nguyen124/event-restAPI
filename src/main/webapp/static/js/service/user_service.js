'use strict';

(function(module) {
	var userService = function($http, $q) {

		var REST_SERVICE_URI = 'http://localhost:8080/MyApp/user/';

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
				console.error('Error while fetching users');
				deferred.reject(err);
			});
			return deferred.promise;
		}

		function createUser(user) {
			var deferred = $q.defer();
			$http.post(REST_SERVICE_URI, user).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.error('Error while creating users');
				deferred.reject(err);
			});

			return deferred.promise;
		}

		function updateUser(user, id) {
			var deferred = $q.defer();
			$http.put(REST_SERVICE_URI + id, user).then(function(response) {
				deferred.resolve(response.data);
			}, function(err) {
				console.error('Error while updating user');
				deferred.reject(err);
			});
			return deferred.promise;
		}

		function deleteUser(id) {
			var deferred = $q.defer();
			$http.delete(REST_SERVICE_URI+id).then(function(response){
				deferred.resolve(response.data);
			}, function(err){
				console.error('Error while deleting user');
				deferred.reject(err);
			});
			return deferred.promise;
		}
	};

	module.factory('UserService', userService);
}(angular.module('myApp')));
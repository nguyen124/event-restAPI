'use strict';

(function(module) {
	var controller = function($scope, UserService) {
		var self = this;

		self.user = {
			id : null,
			username : '',
			address : '',
			email : ''
		};
		self.users = [];
		self.submit = submit;
		self.edit = edit;
		self.remove = remove;
		self.reset = reset;

		fetchAllUsers();

		function fetchAllUsers() {
			UserService.fetchAllUsers().then(function(data) {
				self.users = data;
			}, function(err) {
				console.error(err);
			});
		}

		function createUser(user) {
			UserService.createUser(user).then(fetchAllUsers,
					function(errResponse) {
						console.error('Error while creating User');
					});
		}

		function updateUser(user, id) {
			UserService.updateUser(user, id).then(fetchAllUsers,
					function(errResponse) {
						console.error('Error while updating User');
					});
		}

		function deleteUser(id) {
			UserService.deleteUser(id).then(fetchAllUsers,
					function(errResponse) {
						console.error('Error while deleting User');
					});
		}

		function submit() {
			if (self.user.id === null) {
				console.log('Saving new user', self.user);
				createUser(self.user);
			} else {
				updateUser(self.user, self.user.id);
				console.log('User updated with id', self.user.id);
			}
			reset();
		}

		function edit(id) {
			console.log('id to be edited', id);
			for (var i = 0; i < self.users.length; i++) {
				if (users.users[i].id === id) {
					self.user = angular.copy(self.users[i]);
					break;
				}
			}
		}

		function remove(id) {
			console.log('id to be deleted', id);
			if (self.user.id === id) {
				reset();
			}
			deleteUser(id);
		}

		function reset() {
			self.user = {
				id : null,
				username : '',
				address : '',
				email : ''
			};
			$scope.myForm.$setPristine();
		}
	};
	module.controller('UserController', controller);
}(angular.module('myApp')))
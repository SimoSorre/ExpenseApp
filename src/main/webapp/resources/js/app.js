angular
	.module('expenseApp',['ngResource'])
	.factory('AccountService', function($resource){
		return $resource('http://localhost:8080/expenseapp/accounts/:account',{account: "@account"});
		
	})
	.controller('AccountController', function($scope, AccountService){
		$scope.accounts = AccountService.query();
		$scope.singleAccount = AccountService.get({account: 1});
	});

angular
	.module('expenseApp',['ngResource'])
	.factory('AccountService', function($resource){
		return $resource('http://localhost:8080/expenseapp/accounts/:account',{account: "@account"});
		
	})
	.factory('TotalService', function($resource){
		return $resource('http://localhost:8080/expenseapp/total/:totale',{totale: "@totale"});
	})
	.controller('AccountController', function($scope, AccountService){
		$scope.accounts = AccountService.query();
		$scope.singleAccount = AccountService.get({account: 1});
	})
	.controller('TotalController', function($scope, TotalService){
		$scope.totale = TotalService.get();
	});

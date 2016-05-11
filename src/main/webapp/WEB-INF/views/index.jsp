<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html ng-app="expenseApp">
  <head>
  	<script src='<c:url value="/resources/js/angular.min.js" />'></script>
  	<script src='<c:url value="/resources/js/angular-resource.min.js" />'></script>
  	<script src='<c:url value="/resources/js/app.js" />'></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
  </head>
  <body>
  
  	<div class="container" ng-controller="AccountController">
	  	<table class="table table-hover">
	  		<thead>
	  			<tr>
	  				<th>ID</th>
	  				<th>Nome</th>
	  				<th>Saldo</th>
	  				<th></th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<tr ng-repeat="account in accounts | filter:query" >
	  				<td>{{account.id}}</td>
	  				<td>{{account.name}}</td>
	  				<td>{{account.balance}}</td>
	  				<td></td>
	  			</tr>
	  		</tbody>
	  	</table>
  	</div>
  	
  	<div>
  		<div class="container" ng-controller="TotalController">
  			<h1>GET Totale</h1>
	  		<table class="table table-hover">
	  		<thead>
	  			<tr>
	  				<th></th>
	  				<th>Totale</th>
	  				<th>Valuta</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	  			<tr>
		  			<td></td>
			  		<td>{{totale.total}}</td>
			  		<td>{{totale.currency}}</td>
			  	</tr>
		  	</tbody>
	  		</table>
	  	</div>
  	</div>
  </body>
</html>
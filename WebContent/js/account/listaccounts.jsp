<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading"><h2>Account List</h2></div>
	<div class="panel-body">
		<!--     <p>...</p> -->
		<div class="col-lg-4 col-lg-offset-4">
			<input type="search" id="search" class="form-control"
				placeholder="Search using Fuzzy searching" ng-model="searchText">
		</div>
	</div>
		<div class="row">
		<div class="col-lg-12">
<table class="table table-striped table-condensed">
	<thead>
		<tr>
			<th></th>
			<th>Account Number</th>
			<th>Account Type</th>
			<th>Account Balance</th>
			<th>Customer Name</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="account in accountsList | filter:searchText">
			<td><input type="radio" name="account" ng-model="$parent.accountRadio" id="accounts-{{account.accountId}}" value="{{account.accountId}}" checked="checked"></td>
			<td>{{account.accountNumber}}</td>
			<td>{{account.accountType}}</td>
			<td>{{account.accountBalance}}</td>
			<td ng-repeat="(key, value) in account.customers">
				<a href ui-sref="customerlist">{{value.firstName}} {{value.lastName}}</a>
			</td>
		</tr>
		
	</tbody>
</table>
</div>
</div>
<form class="form-horizontal">
	<!-- Button -->
	<div class="form-group">
		<label class="col-md-4 control-label" for="update"></label>
		<div class="col-md-4">
			<button id="delete" name="delete" class="btn btn-primary btn-block" ng-click="deleteAccount();">Delete</button>
			
		</div>
	</div>
</form>
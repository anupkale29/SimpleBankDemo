<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading"><h2>Card Detail List</h2></div>
	<div class="panel-body">
		<!--     <p>...</p> -->
		
		<div class="col-lg-4 col-lg-offset-4">
		<h2>{{selectMsg}}</h2>
		<input type="search" id="search" class="form-control"
				placeholder="Search using Fuzzy searching" ng-model="searchText">
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<table class="table table-striped table-condensed ">
				<thead>
					<tr>
						<th></th>
						<th>Account Number</th>
						<th>Credit Debit Card Number</th>
						<th>Customer Name</th>
						<th>Custumer Email</th>
						<th>Custumer Phone</th>
						<th>Date</th>
						<th>Time</th>
						<th>Notify</th>
				</tr>
				</thead>
				<tbody>
					<tr ng-repeat="frauds in fraudlist | filter:searchText">
						<td><input type="radio" name="frauds" ng-model="$parent.fraudListRadio" id="frauds-{{frauds.fingerPrintId}}" value="{{frauds.fingerPrintId}}" checked="checked"></td>
						<td>{{frauds.creditDebitCardInfo.cardAccount.accountNumber}}</td>
						<td>{{frauds.creditDebitCardInfo.creditDebitCardNumber}}</td>
						<td ng-repeat="(key, value) in frauds.creditDebitCardInfo.cardAccount.customers">
							<a href ui-sref="customerlist">{{value.firstName}} {{value.lastName}}</a>
						</td>
						<td ng-repeat="(key, value) in frauds.creditDebitCardInfo.cardAccount.customers">
							<a href ui-sref="customerlist">{{value.emailID}}</a>
						</td>
						<td ng-repeat="(key, value) in frauds.creditDebitCardInfo.cardAccount.customers">
							<a href ui-sref="customerlist">{{value.phoneNumber}}</a>
						</td>
						<td>{{frauds.date}}</td>
						<td>{{frauds.time}}</td>
						<td>
							<a class="btn btn-xs btn-primary" href="" id="register_{{frauds.fingerPrintId}}"><i class="icon-shopping-cart icon-white"></i> Notify</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<form class="form-horizontal">
	<!-- Button -->
	<div class="form-group">
		<label class="col-md-4 control-label" for="update"></label>
		<div class="col-md-4">
			<button id="delete" name="delete" class="btn btn-primary btn-block" ng-click="deleteFrauds();">Delete</button>
		</div>
	</div>
</form>
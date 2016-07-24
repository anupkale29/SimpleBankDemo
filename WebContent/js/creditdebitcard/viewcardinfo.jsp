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
						<th>Card Holder Name</th>
						<th>Card Type</th>
						<th>Credit Debit Card Number</th>
						<th>Expiry Date</th>
						<th>Register Finger Print</th>
				</tr>
				</thead>
				<tbody>
					<tr ng-repeat="cards in cardlist | filter:searchText">
						<td><input type="radio" name="cards" ng-model="$parent.creditDebitRadio" id="cards-{{cards.creditDebitId}}" value="{{cards.creditDebitId}}" checked="checked"></td>
						<td>{{cards.cardAccount.accountNumber}}</td>
						<td>{{cards.cardHolderName}}</td>
						<td ng-if="cards.cardType==1">Credit</td>
						<td ng-if="cards.cardType==2">Debit</td>
						<td>{{cards.creditDebitCardNumber}}</td>
						<td>{{cards.expiryDate}}</td>
						<td>
							<a class="btn btn-xs btn-primary" href="" ng-click="callFingerPrint(cards.creditDebitId)" id="register_{{cards.creditDebitId}}"><i class="icon-shopping-cart icon-white"></i> Register</a>
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
			<button id="delete" name="delete" class="btn btn-primary btn-block" ng-click="deleteFingerPrint();">Delete</button>
		</div>
	</div>
</form>
<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading"><h2>Customer List</h2></div>
	<div class="panel-body">
		<!--     <p>...</p> -->
		<div class="col-lg-4 col-lg-offset-4">
		<h2>{{selectMsg}}</h2>
			<input type="search" id="search" class="form-control"
				placeholder="Search using Fuzzy searching" ng-model="searchText">
		</div>
	</div>
	<!-- <div class="row"> -->
	<!-- 	<div class="col-lg-4 col-lg-offset-4"> -->
	<!-- 		<input type="search" id="search" value="" class="form-control" placeholder="Search using Fuzzy searching"> -->
	<!-- 	</div> -->
	<!-- </div> -->
	<div class="row">
		<div class="col-lg-12">
			<table class="table table-striped table-condensed ">
				<thead>
					<tr>
						<th></th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email ID</th>
						<th>Phone Number</th>
						<th>Address</th>
						<th>City</th>
						<th>Pincode</th>
						<th>Country</th>

					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="customer in customerlist | filter:searchText">
						<td><input type="radio" name="customers" ng-model="$parent.customerRadio" id="customers-{{customer.customerId}}" value="{{customer.customerId}}" checked="checked"></td>
						<td>{{customer.firstName}}</td>
						<td>{{customer.lastName}}</td>
						<td>{{customer.emailID}}</td>
						<td>{{customer.phoneNumber}}</td>
						<td>{{customer.address}}</td>
						<td>{{customer.city}}</td>
						<td>{{customer.pincode}}</td>
						<td>{{customer.country}}</td>
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
			<button id="delete" name="delete" class="btn btn-primary btn-block" ng-click="deleteCustomer();">Delete</button>
			
		</div>
	</div>
</form>
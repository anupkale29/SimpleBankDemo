<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading"><h2>Add Customer</h2></div>
	 <div class="panel-body">
		<p></p>
	</div>

<form class="form-horizontal" ng-submit="savecustomer()">
<fieldset>

<!-- Form Name -->
<!-- <legend>Add Customer</legend> -->

<!-- Text input -->
<!-- <div class="form-group">
  <label class="col-md-4 control-label" for="customerId">Customer ID</label>  
  <div class="col-md-5">
  <input id="customerId" name="customerId" placeholder="Customer ID"  ng-model="customer.customerId" class="form-control input-md" type="text">
    
  </div>
</div> -->

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="firstName">First Name</label>  
  <div class="col-md-5">
  <input id="firstName" name="firstName" placeholder="Enter Your Customer Name"  ng-model="customer.firstName" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="lastName">Last Name</label>  
  <div class="col-md-5">
  <input id="lastName" name="lastName" placeholder="Enter Your Last Name"  ng-model="customer.lastName" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="emailID">Email ID</label>  
  <div class="col-md-5">
  <input id="emailID" name="emailID" placeholder="Enter Your Email ID"  ng-model="customer.emailID" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>  
  <div class="col-md-5">
  <input id="password" name="password" placeholder="Enter Your Password"  ng-model="customer.password" class="form-control input-md" required="" type="password">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phoneNumber">Phone Number</label>  
  <div class="col-md-4">
  <input id="phoneNumber" name="phoneNumber" placeholder="Phone Number"  ng-model="customer.phoneNumber" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address</label>  
  <div class="col-md-5">
  <input id="address" name="address" placeholder="Address"  ng-model="customer.address" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="city">City</label>  
  <div class="col-md-5">
  <input id="city" name="city" placeholder="City"  ng-model="customer.city" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="pincode">pincode</label>  
  <div class="col-md-5">
  <input id="pincode" name="pincode" placeholder="Pincode"  ng-model="customer.pincode" class="form-control input-md" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="country">Country</label>  
  <div class="col-md-4">
  <input id="country" name="country" placeholder="Country"  ng-model="customer.country" class="form-control input-md" type="text">
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="save"></label>
  <div class="col-md-8">
    <button type="submit" id="save" name="save" class="btn btn-primary">Save</button>
    <button id="cancel" name="cancel" class="btn btn-primary">Cancel</button>
  </div>
</div>

</fieldset>
</form>
</div>
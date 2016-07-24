<form class="form-horizontal"  ng-submit="saveaccount()">
<fieldset>

<!-- Form Name -->
<legend>Create Account</legend>

<!-- Text input-->
<!-- <div class="form-group">
  <label class="col-md-4 control-label" for="accountId">Account ID</label>  
  <div class="col-md-5">
  <input id="accountId" name="accountId" ng-model="account.accountId" placeholder="Account ID" class="form-control input-md" required="" type="text">
  </div>
</div> -->

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="accountType">Account Type</label>
  <div class="col-md-5">
    <select id="accountType" name="accountType" class="form-control" ng-model="account.accountType">
      <option value="Savings" >Savings </option>
      <option value="Current" >Current </option>
    </select>
  </div>
</div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="accountNo">Account Number</label>  
  <div class="col-md-5">
  <input id="accountNo" name="accountNo" ng-model="account.accountNumber" placeholder="Enter Your Account Number" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="openingBalance">Opening Balance</label>  
  <div class="col-md-5">
  <input id="openingBalance" name="openingBalance" ng-model="account.openingBalance" placeholder="Enter Your Opening Balance" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="customer">Select Customer</label>
  <div class="col-md-5">
    <select id="customer" name="customer" class="form-control" ng-model="account.customerId">
      <option value="{{customer.customerId}}" ng-repeat="customer in  customers">{{customer.firstName}} {{customer.lastName}}</option>
    </select>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="save"></label>
  <div class="col-md-8">
    <button id="save" name="save" class="btn btn-primary">Save</button>
    <button id="cancel" name="cancel" class="btn btn-primary">Cancel</button>
  </div>
</div>

</fieldset>
</form>

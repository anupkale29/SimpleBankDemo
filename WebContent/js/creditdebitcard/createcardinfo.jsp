<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading"><h2>Add Card Information</h2></div>
	 <div class="panel-body">
		<p></p>
	</div>

<form class="form-horizontal" ng-submit="saveCreditDebitInfo()">
<fieldset>


<div class="form-group">
  <label class="col-md-4 control-label" for="cardType">Card Type</label>
  <div class="col-md-5">
    <select id="cardType" name="cardType" class="form-control" ng-model="creditDebitCardInfo.cardType">
      <option value="1" >Credit Account </option>
      <option value="2" >Debit Account </option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cardHolderName">Card Holder Name</label>  
  <div class="col-md-5">
  <input id="cardHolderName" name="cardHolderName" placeholder="Enter Card Holder Name"  ng-model="creditDebitCardInfo.cardHolderName" class="form-control input-md" required="" type="text">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="creditDebitCardNumber">Credit/Debit Card Number</label>  
  <div class="col-md-5">
  <input id="creditDebitCardNumber" name="creditDebitCardNumber" placeholder="Enter Credit/Debit Card Number"  ng-model="creditDebitCardInfo.creditDebitCardNumber" class="form-control input-md" type="text">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="expiryDate">Expiry Date</label>  
  <div class="col-md-5">
  <input id="expiryDate" name="expiryDate" placeholder="DD/MM/YYYY"  ng-model="creditDebitCardInfo.expiryDate" class="form-control input-md" type="text">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="expiryDate">CVV</label>  
  <div class="col-md-5">
  <input id="cvv" name="cvv" placeholder="Enter CVV"  ng-model="creditDebitCardInfo.cvv" class="form-control input-md" type="text">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="expiryDate">Pin Number</label>  
  <div class="col-md-5">
  <input id="pin" name="pin" placeholder="Enter Pin Number"  ng-model="creditDebitCardInfo.pin" class="form-control input-md" type="text">
  </div>
</div>

 <div class="form-group">
  <label class="col-md-4 control-label" for="account">Select Account</label>
  <div class="col-md-5">
    <select id="accountId" name="accountId" class="form-control" ng-model="creditDebitCardInfo.accountId">
      <option value="{{account.accountId}}" ng-repeat="account in accountList">{{account.accountNumber}}</option>
    </select>
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
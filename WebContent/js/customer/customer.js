angular.module('ngBoilerplate.customer', ['ui.router', 'ngResource', 'base64'])
.config(function($stateProvider) {
	$stateProvider.state('createcustomer', {
		url : '/createcustomer',
		views : {
			'main' : {
				templateUrl : 'js/customer/createcustomer.jsp',
				controller: 'CreateCustomerCtrl'
			}
		},
		data : {
			pageTitle : "Customer Creation Form"
		}
	})
	.state('customerlist', {
		url : '/customerlist',
		views : {
			'main' : {
				templateUrl : 'js/customer/customerlist.jsp',
				controller: 'CustomerListCtrl'
			}
		},
		data : {
			pageTitle : "Customer List"
		}
	})
	.state('showcustomers', {
		url : '/showcustomers',
		views : {
			'main' : {
				templateUrl : 'js/customer/customerlist.jsp'
//				controller: 'CustomerListCtrl'
			}
		},
		data : {
			pageTitle : "Customer List"
		}
	});
})
.factory('customerService', function($resource,$http,$location) {
    var service = {};
//    var urlBase="http://localhost:8085/BankDemo";
    var urlBase=$location.absUrl().substr(0,$location.absUrl().substr(0, $location.absUrl().lastIndexOf("#")).lastIndexOf("/"));
    $http.defaults.headers.post["Content-Type"] = 'application/json;charset=UTF-8';
    service.createcustomer = function(customer, success) {
    	$http({
    	    method : 'POST',
    	    url : urlBase +'/rest/user/saveCustomer.json',
    	    data : $.param({
    	        'customerId' : customer.customerId,
    	        'firstName' : customer.firstName,
    	        'lastName' : customer.lastName,
    	        'emailID' : customer.emailID,
    	        'phoneNumber' : customer.phoneNumber,
    	        'address' : customer.address,
    	        'city' : customer.city,
    	        'pincode' : customer.pincode,
    	        'country' : customer.country
    	    }),
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	service.getcustomers = function(success) {
    	$http({
    	    method : 'GET',
    	    data : $.param({}),
    	    url : urlBase +'/rest/user/getCustomers.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	service.deleteCustomer = function(customerId,success) {
    	$http({
    	    method : 'POST',
    	    data : $.param({
    	    	'customerId' : customerId
    	    }),
    	    url : urlBase +'/rest/user/deleteCustomer.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	 return service;
})
.controller("CreateCustomerCtrl", function($scope, $state, customerService) {
    $scope.savecustomer = function() {
    	customerService.createcustomer($scope.customer,
        function(returnedData) {
    		 $state.go("home");
        },
        function() {
            alert("Error registering Customer");
        });
    };
})
.controller("CustomerListCtrl", function($scope, $state, customerService) {
	$scope.deleteCustomer = function() {
		if($scope.customerRadio!=undefined){
			customerService.deleteCustomer($scope.customerRadio,function(returnedData) {
        		$state.go($state.current,{},{reload:true});		
            },
            function() {
                alert("Error getting Cards");
            });
		}else{
			$scope.selectMsg="No records selected.";
		}
    	};
	
	
    $scope.customerlist = [];
    	customerService.getcustomers(function(returnedData) {
    		$scope.customerlist=returnedData;
//    		 $state.go("showcustomers");
        },
        function() {
            alert("Error getting Customers");
        });
    
});
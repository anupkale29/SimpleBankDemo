angular.module('ngBoilerplate.creditdebitcard', ['ui.router', 'ngResource', 'base64', 'ngBoilerplate.account'])
.config(function($stateProvider) {
	$stateProvider
	.state('createcardinfo', {
		url : '/createcardinfo',
		views : {
			'main' : {
				templateUrl : 'js/creditdebitcard/createcardinfo.jsp',
				controller: 'CreateCardInfoCtrl'
			}
		},
		data : {
			pageTitle : "Card Creation Form"
		}
	})
	.state('viewcardinfo', {
		url : '/viewcardinfo',
		views : {
			'main' : {
				templateUrl : 'js/creditdebitcard/viewcardinfo.jsp',
				controller: 'CardListCtrl'
			}
		},
		data : {
			pageTitle : "Card List"
		}
	}).state('viewfrauds', {
		url : '/viewfrauds',
		views : {
			'main' : {
				templateUrl : 'js/creditdebitcard/viewfrauds.jsp',
				controller: 'FraudListCtrl'
			}
		},
		data : {
			pageTitle : "Card Creation Form"
		}
	});
})
.factory('cardService', function($resource,$http,$location) {
    var service = {};
    var urlBase=$location.absUrl().substr(0,$location.absUrl().substr(0, $location.absUrl().lastIndexOf("#")).lastIndexOf("/"));
    $http.defaults.headers.post["Content-Type"] = 'application/json;charset=UTF-8';
    service.createcard = function(creditDebitCardInfo, success) {
    	$http({
    	    method : 'POST',
    	    url : urlBase +'/rest/user/saveCardDetails.json',
    	    data : $.param({
    	        'cardType' : creditDebitCardInfo.cardType,
    	        'cardHolderName' : creditDebitCardInfo.cardHolderName,
    	        'creditDebitCardNumber' : creditDebitCardInfo.creditDebitCardNumber,
    	        'expiryDate' : creditDebitCardInfo.expiryDate,
    	        'accountId' : creditDebitCardInfo.accountId,
    	        'cvv' : creditDebitCardInfo.cvv,
    	        'pin' : creditDebitCardInfo.pin
    	    }),
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	service.getCards = function(success) {
    	$http({
    	    method : 'GET',
    	    data : $.param({}),
    	    url : urlBase +'/rest/user/getCards.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	service.getFrauds = function(success) {
    	$http({
    	    method : 'GET',
    	    data : $.param({}),
    	    url : urlBase +'/rest/user/getFrauds.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	service.callFingerPrint = function(creditDebitId,success) {
    	$http({
    	    method : 'POST',
    	    data : $.param({
    	    	'creditDebitId' : creditDebitId
    	    }),
    	    url : urlBase +'/rest/user/callFingerPrint.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	service.deleteFingerPrint = function(creditDebitId,success) {
    	$http({
    	    method : 'POST',
    	    data : $.param({
    	    	'creditDebitId' : creditDebitId
    	    }),
    	    url : urlBase +'/rest/user/deleteFingerPrint.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	service.deleteFrauds = function(fingerPrintId,success) {
    	$http({
    	    method : 'POST',
    	    data : $.param({
    	    	'fingerPrintId' : fingerPrintId
    	    }),
    	    url : urlBase +'/rest/user/deleteFrauds.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	 return service;
})
.controller("CreateCardInfoCtrl", function($scope, $state, cardService, accountService) {
    $scope.saveCreditDebitInfo = function() {
    	cardService.createcard($scope.creditDebitCardInfo,
        function(returnedData) {
    		 $state.go("home");
        },
        function() {
            alert("Error registering Cards");
        });
    };
    
    $scope.accountList = [];
    accountService.getAccounts(function(returnedData) {
		$scope.accountList=returnedData;
//		 $state.go("showcustomers");
    },
    function() {
        alert("Error getting Accounts");
    });
})
.controller("CardListCtrl", function($scope, $state, cardService) {
    $scope.cardlist = [];
    cardService.getCards(function(returnedData) {
    		$scope.cardlist=returnedData;
//    		 $state.go("showcustomers");
        },
        function() {
            alert("Error getting Cards");
        });
    $scope.callFingerPrint = function(creditDebitId) { 
    	cardService.callFingerPrint(creditDebitId,function(returnedData) {
//    		$scope.cardlist=returnedData;
//    		 $state.go("showcustomers");
        },
        function() {
            alert("Error getting Cards");
        });
    	};
    	
    	$scope.deleteFingerPrint = function() {
    		if($scope.creditDebitRadio!=undefined){
	        	cardService.deleteFingerPrint($scope.creditDebitRadio,function(returnedData) {
	        		$state.go($state.current,{},{reload:true});		
	            },
	            function() {
	                alert("Error getting Cards");
	            });
    		}else{
    			$scope.selectMsg="No records selected.";
    		}
        	};
}).controller("FraudListCtrl", function($scope, $state, cardService) {
    $scope.cardlist = [];
    cardService.getFrauds(function(returnedData) {
    		$scope.fraudlist=returnedData;
//    		 $state.go("showcustomers");
        },
        function() {
            alert("Error getting Cards");
        });
    
    $scope.deleteFrauds = function() {
		if($scope.fraudListRadio!=undefined){
        	cardService.deleteFrauds($scope.fraudListRadio,function(returnedData) {
        		$state.go($state.current,{},{reload:true});		
            },
            function() {
                alert("Error getting Cards");
            });
		}else{
			$scope.selectMsg="No records selected.";
		}
    	};
});
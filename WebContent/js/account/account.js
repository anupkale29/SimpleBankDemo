angular.module('ngBoilerplate.account', ['ui.router', 'ngResource', 'base64','ngBoilerplate.customer'])
.config(function($stateProvider) {
    $stateProvider.state('login', {
        url:'/login',
        views: {
            'main': {
                templateUrl:'js/account/login.tpl.jsp',
                controller: 'LoginCtrl'
            }
        },
        data : { pageTitle : "Login" }
    })
    .state('register', {
            url:'/register',
            views: {
                'main': {
                    templateUrl:'js/account/register.tpl.jsp',
                    controller: 'RegisterCtrl'
                }
            },
            data : { pageTitle : "Registration" }
     })
     .state('createaccount', {
				url : '/createaccount',
				views : {
					'main' : {
						templateUrl : 'js/account/createaccount.jsp',
						controller: 'CreateAccountCtrl'
					}
				},
				data : {
					pageTitle : "Account Creation Form"
				}
	})
	.state('listaccounts', {
				url : '/listaccounts',
				views : {
					'main' : {
						templateUrl : 'js/account/listaccounts.jsp',
						controller: 'ListAccountsCtrl'
					}
				},
				data : {
					pageTitle : "Accounts List"
				}
	});
// .state('userSearch', {
// url:'/accounts/search',
//            views: {
//                'main': {
//                    templateUrl:'js/account/search.tpl.jsp',
//                    controller: 'UserSearchCtrl'
//                }
//            },
//            data : { pageTitle : "Search Users" },
//            resolve: {
//                users: function(userService) {
//                    return userService.getAllAccounts();
//                }
//            }
//    });
})
 .factory('sessionService',function($http, $base64) {
		var session = {};
		session.login = function(data) {
			if(data!=undefined&&data!="")
				localStorage.setItem("session", data);
			else{
				localStorage.removeItem("session");
			}
		};
		session.logout = function() {
			localStorage.removeItem("session");
		};
		session.isLoggedIn = function() {
			return (localStorage.getItem("session")!=undefined&&localStorage.getItem("session") !== null);
		};
		return session;
	})
.factory('userService', function($resource,$http,$location) {
    var service = {};
    var urlBase=$location.absUrl().substr(0,$location.absUrl().substr(0, $location.absUrl().lastIndexOf("#")).lastIndexOf("/"));
    $http.defaults.headers.post["Content-Type"] = 'application/json;charset=UTF-8';
    service.register = function(user, success) {
    	$http({
    	    method : 'POST',
    	    url : urlBase +'/rest/user/saveUser.json',
    	    data : $.param({
    	        'usernamesignup' : user.userName,
    	    	'emailsignup' : user.userId,
    	        'passwordsignup' : user.password,
    	        'passwordsignup_confirm' : user.conformPassword
    	    }),
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
    service.getUserById = function(user, success, failure) {
    	$http({
    	    method : 'POST',
    	    url : urlBase +'/rest/user/checkvaliduser.json',
    	    data : $.param({
    	    	'emailId' : user.userId,
    	        'password' : user.password,
    	    }),
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success).error(failure);
    };
    service.userExists = function(user, success, failure) {
        var User = $resource("/rest/user");
        var data = User.get({name:user.userId, password:user.password}, function() {
            var users = data.users;
            if(users.length !== 0) {
                success(users);
            } else {
                failure();
            }
        },
        failure);
    };
    service.getAllAccounts = function() {
          var User = $resource("/basic-web-app/rest/accounts");
          return User.get().$promise.then(function(data) {
            return data.users;
          });
      };
    return service;
})
.factory('accountService', function($resource,$http,$location) {
    var service = {};
//    var urlBase="http://localhost:8085/BankDemo";
    var urlBase=$location.absUrl().substr(0,$location.absUrl().substr(0, $location.absUrl().lastIndexOf("#")).lastIndexOf("/"));
    $http.defaults.headers.post["Content-Type"] = 'application/json;charset=UTF-8';
    service.createaccount = function(account, success) {
    	$http({
    	    method : 'POST',
    	    url : urlBase +'/rest/user/saveAccount.json',
    	    data : $.param({
    	        'accountType' : account.accountType,
    	        'accountNumber' : account.accountNumber,
    	        'openingBalance' : account.openingBalance,
    	        'customerId' : account.customerId
    	        }),
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	service.getAccounts = function(success) {
    	$http({
    	    method : 'GET',
    	    data : $.param({}),
    	    url : urlBase +'/rest/user/getAccounts.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	service.deleteAccount = function(accountId,success) {
    	$http({
    	    method : 'POST',
    	    data : $.param({
    	    	'accountId' : accountId
    	    }),
    	    url : urlBase +'/rest/user/deleteAccount.json',
    	    headers : {
    	        'Content-Type' : 'application/x-www-form-urlencoded'
    	    }
    	}).success(success);
	};
	
	 return service;
})
.controller("LoginCtrl", function($scope,sessionService ,$state,userService) {
    $scope.login = function() {
    	userService.getUserById($scope.user, function(returnedData) {
			sessionService.login(returnedData);
			$state.go("home");
		}, function() {
			alert("User Not Present");
			 sessionService.logout();
		});
    };
})
.controller("RegisterCtrl", function($scope, sessionService, $state, userService) {
    $scope.register = function() {
    	userService.register($scope.user,
        function(returnedData) {
            sessionService.login($scope.user);
            $state.go("home");
        },
        function() {
            alert("Error registering user");
        });
    };
})
.controller("AccountSearchCtrl", function($scope, accounts) {
    $scope.accounts = accounts;
})
.controller("CreateAccountCtrl", function($scope, $state, accountService,customerService) {
    $scope.saveaccount = function() {
    	accountService.createaccount($scope.account,
        function(returnedData) {
    		 $state.go("home");
        },
        function() {
            alert("Error registering account");
        });
    };
    
    $scope.customers = [];
	customerService.getcustomers(function(returnedData) {
		$scope.customers=returnedData;
//		 $state.go("showcustomers");
    },
    function() {
        alert("Error getting Customers");
    });
}).controller("ListAccountsCtrl", function($scope, $state,accountService, customerService) {
	$scope.deleteAccount = function() {
		if($scope.accountRadio!=undefined){
			accountService.deleteAccount($scope.accountRadio,function(returnedData) {
        		$state.go($state.current,{},{reload:true});		
            },
            function() {
                alert("Error getting Cards");
            });
		}else{
			$scope.selectMsg="No records selected.";
		}
    	};
	
	
	$scope.accountsList = [];
	    accountService.getAccounts(function(returnedData) {
			$scope.accountsList=returnedData;
//			 $state.go("showcustomers");
	    },
	    function() {
	        alert("Error getting Accounts");
	    });
});
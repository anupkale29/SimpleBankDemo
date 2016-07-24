<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html ng-app="ngBoilerplate" ng-controller="AppCtrl" lang="en" >

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title ng-click="home">BANK DEMO</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<link href="css/git-hub.css" rel="stylesheet">
<link href="css/git-hub2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href ui-sref="home">Bank Demo</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Manage Customers<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href ui-sref="createcustomer">Add Customer</a></li>
							<li><a href ui-sref="customerlist">View Customers</a></li>
						</ul>
				    </li>
				    <li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Manage Accounts<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href ui-sref="createaccount">Create Account</a></li>
							<li><a href ui-sref="listaccounts">View Accounts</a></li>
						</ul></li>
				    <li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown">Manage Credit/Debit Cards<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href ui-sref="createcardinfo">Add Credit/Debit Cards</a></li>
							<li><a href ui-sref="viewcardinfo">View Credit/Debit Cards</a></li>
						</ul>
				    </li>
				    <li><a href ui-sref="viewfrauds">View Fraud's</a></li>
				     
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div ui-view="main"></div>
		<hr>
		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/vendor/jquery.js"></script>
	<script src="js/vendor/angular.js"></script>
	<script src="js/vendor/angular-base64.js"></script>
	<script src="js/vendor/angular-hateoas.js"></script>
	<script src="js/vendor/angular-resource.js"></script>
	<script src="js/vendor/angular-ui-router.js"></script>
	<script src="js/vendor/angular-route.js"></script>
	<script src="js/vendor/angular-animate.js"></script>
	<script src="js/vendor/angular-cookies.js"></script>
	<script src="js/vendor/angular-loader.js"></script>
	<script src="js/vendor/angular-touch.js"></script>
	<script src="js/home/home.js"></script>
	<script src="js/account/account.js"></script>
	<script src="js/customer/customer.js"></script>
	<script src="js/creditdebitcard/creditdebitcard.js"></script>
	<script src="js/app.js"></script>
	<script src="js/tempfolder/temp.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/vendor/bootstrap.js"></script>
	<!-- Script to Activate the Carousel -->
</body>

</html>

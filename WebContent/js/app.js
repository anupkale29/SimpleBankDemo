angular.module( 'ngBoilerplate', [
  'ngBoilerplate.home',
  'ngBoilerplate.account',
  'ngBoilerplate.customer',
  'ngBoilerplate.temp',
  'ngBoilerplate.creditdebitcard',
  'ui.router',
  'hateoas'
])
.config( function myAppConfig ( $stateProvider, $urlRouterProvider, HateoasInterceptorProvider) {
  $urlRouterProvider.otherwise( '/home' );
  HateoasInterceptorProvider.transformAllResponses();
})
.run( function run () {
})
.controller( 'AppCtrl', function AppCtrl ( $scope, $location,sessionService) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | Bank Demo' ;
      $scope.isLoggedIn = sessionService.isLoggedIn;
      $scope.logout = sessionService.logout;
    }
  });
  $scope.loadData = function(menu)
  {
      $scope.menu = JSON.parse(menu);
  };
});


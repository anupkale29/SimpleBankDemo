angular.module( 'ngBoilerplate.temp', [
  'ui.router'
]).config(function config( $stateProvider ) {
	  $stateProvider.state( '404', {
	    url: '/404',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/404.jsp'
	      }
	    },
	    data:{ pageTitle: '404' }
	  });
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'about', {
	    url: '/about',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/about.jsp'
	      }
	    },
	    data:{ pageTitle: 'about' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'blog-home-1', {
	    url: '/blog-home-1',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/blog-home-1.jsp'
	      }
	    },
	    data:{ pageTitle: 'blog-home-1' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'blog-home-2', {
	    url: '/blog-home-2',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/blog-home-2.jsp'
	      }
	    },
	    data:{ pageTitle: 'blog-home-2' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'blog-post', {
	    url: '/blog-post',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/blog-post.jsp'
	      }
	    },
	    data:{ pageTitle: 'blog-post' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'contact', {
	    url: '/contact',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/contact.jsp'
	      }
	    },
	    data:{ pageTitle: 'contact' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'faq', {
	    url: '/faq',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/faq.jsp'
	      }
	    },
	    data:{ pageTitle: 'faq' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'full-width', {
	    url: '/full-width',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/full-width.jsp'
	      }
	    },
	    data:{ pageTitle: 'full-width' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'portfolio-1-col', {
	    url: '/portfolio-1-col',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/portfolio-1-col.jsp'
	      }
	    },
	    data:{ pageTitle: 'portfolio-1-col' }
	});	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'portfolio-2-col', {
	    url: '/portfolio-2-col',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/portfolio-2-col.jsp'
	      }
	    },
	    data:{ pageTitle: 'portfolio-2-col' }
	});	 
	 
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'portfolio-3-col', {
	    url: '/portfolio-3-col',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/portfolio-3-col.jsp'
	      }
	    },
	    data:{ pageTitle: 'portfolio-3-col' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'portfolio-4-col', {
	    url: '/portfolio-4-col',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/portfolio-4-col.jsp'
	      }
	    },
	    data:{ pageTitle: 'portfolio-4-col' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'portfolio-item', {
	    url: '/portfolio-item',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/portfolio-item.jsp'
	      }
	    },
	    data:{ pageTitle: 'portfolio-item' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'pricing', {
	    url: '/pricing',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/pricing.jsp'
	      }
	    },
	    data:{ pageTitle: 'pricing' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'services', {
	    url: '/services',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/services.jsp'
	      }
	    },
	    data:{ pageTitle: 'services' }
	});
}).config(function config( $stateProvider ) {
	 $stateProvider.state( 'sidebar', {
	    url: '/sidebar',
	    views: {
	      "main": {
	        templateUrl: 'js/tempfolder/sidebar.jsp'
	      }
	    },
	    data:{ pageTitle: 'sidebar' }
	});
});
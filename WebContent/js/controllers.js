'use strict';

/* Controllers */

angular
  .module('BeerControllers', [])
  .controller('BeerListCtrl', ['$scope', '$http', function($scope, $http) {
	
	// appel servlet pour obtenir la liste de bières au format json  
    $http.get('BeerList').success(function(data) {
      $scope.beers = data;
    });

    $scope.orderProp = 'alcohol';
  }])
  .controller('BeerDetailCtrl', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {
    $http.get('BeerDetail?id=' + $routeParams.beerId).success(function(data) {
      $scope.beer = data;
    });
  }]);


var app = angular.module('appTippspiel', []);

app.controller('start', function($scope, $http) {
	load($scope, $http);
});

function load($scope, $http) {
	$scope.title = "Tippspiel Grassertippen";	
	$scope.memberSummaries = [];
	$scope.isLoading = false;
	
	$scope.isLoading = true;
	$http.get("/tippspiel/api/v1/members/all?" + Math.random())
	.then(function(response) {
		$scope.memberSummaries = response.data;	
		$scope.subtitle = "Alle Tipper";	
		$scope.isLoading = false;					
	});
	
	$http.get("/tippspiel/api/v1/tournaments/all?" + Math.random())
	.then(function(responseTournament) {
		$scope.tournaments = responseTournament.data;	
	})	
}
var app = angular.module('appTippspiel', []);

app.controller('start', function($scope, $http) {
	load($scope, $http);
	
	$scope.showDetails = function(item) {
		$scope.detailMemberSummary = item.name;		
	}
});

function load($scope, $http) {
	$scope.title = "Tippspiel Grassertippen";	
	$scope.detailMemberSummary = "";
	$scope.memberSummaries = [];
	$scope.isLoading = false;
	
	$scope.isLoading = true;
	$http.get("/tippspiel/api/v1/members?" + Math.random())
	.then(function(response) {
		$scope.memberSummaries = response.data;	
		$scope.subtitle = "Alle Tipper";	
		$scope.isLoading = false;					
	});
	
	$http.get("/tippspiel/api/v1/tournaments?" + Math.random())
	.then(function(responseTournament) {
		$scope.tournaments = responseTournament.data;	
	})	
}

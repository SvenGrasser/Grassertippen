var app = angular.module('appTippspiel', []);

app.controller('start', function($scope, $http) {
	$scope.title = "Tippspiel Grassertippen";	
	$scope.members = [];
	$scope.isLoading = false;
	
	$scope.loadMembers = function() {
		$scope.isLoading = true;
		$http.get("/tippspiel/api/v1/members/all?" + Math.random())
		.then(function(response) {
			$scope.members = response.data;	
			$scope.subtitle = "Alle Tipper";	
			$scope.isLoading = false;
			$http.get("/tippspiel/api/v1/tournaments/all?" + Math.random())
			.then(function(responseTournament) {
				$scope.tournaments = responseTournament.data;	
			})			
		});
	}
});
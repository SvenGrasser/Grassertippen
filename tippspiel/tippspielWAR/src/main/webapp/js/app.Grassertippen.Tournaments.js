var app = angular.module('appTippspielTournaments', []);

app.controller('tournamentController', function($scope, $http) {
	load($scope, $http);
});

function load($scope, $http) {
	$scope.tournamentWinners = [];
	$http.get("/tippspiel/api/v1/tournamentWinners?" + Math.random())
	.then(function(response) {
		$scope.tournamentWinners = response.data;		
	});
}



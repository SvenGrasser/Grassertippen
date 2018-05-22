var app = angular.module('appTippspiel', []);

app.controller('summaryController', function($scope, $http) {
	load($scope, $http);
	
	$scope.showDetails = function(memberSummary) {
		showMemberSummaryDetails($scope, $http, memberSummary);
	}
	
	$scope.checkboxModel = {
		       value1 : true,
		       value2 : 'YES'
		     };
});

function load($scope, $http) {
	$scope.title = "Tippspiel Grassertippen";	
	$scope.detailMemberSummary = "";
	$scope.memberSummaries = [];		
	$scope.detailsHidden = true;
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
		var result = "Wettbewerbe: "; 
		responseTournament.data.forEach(
			    function combineTournaments(value) { 
			    	result = result.concat(value.descriptionShort);
			    	result = result.concat("|");
			    }
			);
		$scope.tournaments = result;
	})	
}

function showMemberSummaryDetails($scope, $http, memberSummary) {
	if(memberSummary.memberDetails == null) {	
		$http.get("/tippspiel/api/v1/members/" + memberSummary.id + "?"  + Math.random())
		.then(function(response) {	
			$scope.detailsHidden = false;
			memberSummary.memberDetails = response.data;
		});
	}
}


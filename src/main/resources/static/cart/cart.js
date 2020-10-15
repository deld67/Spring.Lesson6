angular.module('app').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/shop';

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET',

        })
            .then(function (response) {
                $scope.Cart = response.data;
                           });
    };


    $scope.fillTable();
});
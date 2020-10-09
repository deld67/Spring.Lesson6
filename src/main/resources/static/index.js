(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage'])
        .config(config)
        .run();

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                        templateUrl: 'main/main.html'
                    })
            .when('/cartRest', {
                        templateUrl: 'cart/cart.html',
                        controller: 'cartController'
            });

    }
})();

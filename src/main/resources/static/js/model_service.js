'use strict';

angular.module('myApp').factory('ModelService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:7777/model/';


    var factory = {
        fetchAll: fetchAll,
        create: create
    };

    return factory;


    function fetchAll() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function create(model) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, model)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating');
                }
            );
        return deferred.promise;
    }

}]);
'use strict';

angular.module('myApp').controller('ModelController', ['$scope', 'ModelService', function($scope, ModelService) {
    var self = this;
    self.model = {id:null, name:''};
    self.models = [];

    self.submit = submit;

    fetchAll();

    function fetchAll(){
        ModelService.fetchAll()
            .then(
                function(d) {
                    self.models = d;
                },
                function(errResponse){
                    console.error('Error while fetching');
                }
            );
    }

    function create(model){
        ModelService.create(model)
            .then(
                fetchAll,
                function(errResponse){
                    console.error('Error while creating a model');
                }
            );
    }

    function submit() {
        create(self.model);
        reset();
    }

    function reset(){
        self.model = {id:null, name:''};
        $scope.form.$setPristine();
    }

}]);
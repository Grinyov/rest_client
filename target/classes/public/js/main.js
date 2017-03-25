/**
 * Created by green
 */
var app = angular.module("boot_exam", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.websites = [];

    $http.get('http://localhost:8090/api/stackoverflow').success(function (data) {
       $scope.websites = data;
    });
});
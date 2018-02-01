angular.module('AppRouterService', [ 'ui.router' ])
.config(

function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/login'); //默认访问的状态是/login

	$stateProvider.state("login", {
		url : "/login",
		templateUrl : './views/login.html', // 页面
		controller : 'loginCtrl' // 控制器

	})
})

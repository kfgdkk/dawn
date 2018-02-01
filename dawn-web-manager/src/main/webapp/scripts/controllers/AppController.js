

angular
		.module('AppController', [])

		.controller(
				'loginCtrl',
				function($rootScope, $scope, $state, AdminService) { // 将AdminService注入到了当前的loginCtrl中。
					$scope.errorMsg = '';
					$scope.login = function(username, password) {
						// 拼接向服务器发送的数据
						var str = 'username=' + username + '&password='
								+ password;
						// alert(username + " " + password);
						AdminService.signIn(str).success(function(result) {
							if (result.status== 200) {
                                $scope.loginName = username;
                               window.location.href="/admin/index.html";
							} else if (result.status == 400) {
								$scope.errorMsg = '用户名或密码错误';
							} else {
								$scope.errorMsg = '用户登录异常，请联系客服！';
							}
						}).error(function() {
							$scope.errorMsg = '网络异常，稍后重试！';
							$scope.refresh();
						});
					};
					$scope.hideMsg = function() {
						$scope.errorMsg = '';
					};
				})


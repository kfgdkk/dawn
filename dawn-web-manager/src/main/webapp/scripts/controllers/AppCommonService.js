var option = {};
option.url = {
	'api_user' : '/background/user/',
};
option.header = {
	'headers' : {
		'Content-Type' : 'application/x-www-form-urlencoded;charset=UTF-8;'
	}
};
angular
		.module('AppCommonService', [ 'ngCookies' ])
		.factory(
				'AdminService',
				function($http) { //将$http注入，就可以向服务器发送请求
					return {
						signIn : function($str) {
							//alert($str);
							return $http.post(option.url.api_user + 'login'+'.do',
									$str, option.header);
							// /user/login
						}
					}
				})


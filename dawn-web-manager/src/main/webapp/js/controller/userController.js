app.controller('userController',function($scope,$http,$controller,userService){
    $controller('userBaseController',{$scope:$scope});//伪继承//继承里面所有的变量

   //查询分页方法
    $scope.findPage = function(page,rows){
        //get 请求参数时候 多用get post提交数据的时候
        userService.findPage(page,rows).success(function(response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }
    //添加和修改用户的方法
    $scope.save = function() {
        var methodName = null;
        if($scope.entity.id!=null){
            methodName=userService.update($scope.entity.roleId,$scope.entity);
        }else{
            methodName=userService.add($scope.entity.roleId,$scope.entity);
        }
        methodName.success(
            function(response) {
                if (response.success) {
                    $scope.reloadList();
                }
                else {
                    alert(response.message);
                }
            });
    }


    //查询需要修改的用户的信息
    $scope.findOne=function(id){
        userService.findOne(id).success(
            function(response){
                $scope.entity=response;
            });
    }




    //批量删除
    $scope.delete=function(){
        userService.delete($scope.selectIds).success(
            function(response){
                if (response.success) {
                    $scope.reloadList();
                }
                else {
                    alert(response.message);
                }
            });
    }

    //查询用户及分页方法
    $scope.findAll = function(page,rows){
        //get 请求参数时候 多用get post提交数据的时候
        userService.findAll(page,rows).success(function(response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }

});

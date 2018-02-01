app.controller('brandController',function($scope,$http,$controller,brandService){
    $controller('baseController',{$scope:$scope});//伪继承//继承里面所有的变量
// 定义查询品牌方法
    $scope.findAll = function() {
        brandService.findAll().success(
            function(response) {//后端回显回来的数据 属于控制层C 会影响到视图  也会影响到这个变量 mvc
                $scope.list = response;
            });
    }
    //查询分页方法
    $scope.findPage = function(page,rows){
        //get 请求参数时候 多用get post提交数据的时候
        brandService.findPage(page,rows).success(function(response) {
            $scope.paginationConf.totalItems = response.total;
            $scope.list = response.rows;
        });
    }
    //添加和修改品牌方法
    $scope.save = function() {
        var methodName = null;
        if($scope.entity.id!=null){
            methodName=brandService.update($scope.entity);
        }else{
            methodName=brandService.add($scope.entity);
        }
        methodName.success(
            function(response) {
                if (response.success) {
                    $scope.reloadList();
                }
                else {
                    $scope.reloadList();

                }
            });
    }
    //查询实体类方法
    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function(response){
                $scope.entity=response;
            });
    }

    //批量删除
    $scope.delete=function(){
        brandService.delete($scope.selectIds).success(
            function(response){
                if (response.success) {
                    $scope.reloadList();
                }
                else {
                    alert(response.errorMsg);
                }
            });
    }

    $scope.searchEntity={};//定义搜索对象
    //条件查询
    $scope.search=function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }
});
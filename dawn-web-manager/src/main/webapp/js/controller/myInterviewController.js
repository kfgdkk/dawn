 //控制层 
app.controller('myInterviewController' ,function($scope,$controller,myInterviewService){
	
	//$controller('baseController',{$scope:$scope});//继承
    //重新加载列表数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByuserId($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }
    /*
     分页控件配置 currentPage：当前页  totalItems 总记录数 itemsPerPage每页显示条数 perPageOptions页码选项
     onChange 当你改变页码的时候触发一个事件
     */
    //分页控件配置
    $scope.paginationConf  =  {
        currentPage:  1,
        totalItems:  10,
        itemsPerPage:  10,
        perPageOptions:  [10,  20,  30,  40, 50],
        onChange:  function(){
            $scope.reloadList();//重新加载
        }
    };
    /*
     分析  定义一个数组
     1选中复选框存到你定义的数组里 2 取消复选框从你的数组里移除
     angularjs 涉及到两个方法 添加 push  从哪里开始移除  移除splice
     2在你点击删除之前 是跟你后端代码无关 （单独定义一个方法）
     */
    //定义初始化数组
    $scope.selectIds=[];
    //定义选中方法  跟后端的代码无关
    $scope.updateSelection=function($event,id){
        //判断如果被选中 添加到数组
        if($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            //否则是移除   从数组中查找 从哪里开始移除
            var index=$scope.selectIds.indexOf(id);
            //参数1 从哪里开始移除  参数2 移除几个
            $scope.selectIds.splice(index,1)
        }
    }
	

	/**
	 * 根据userid查询所有未通过面试题
	 */
	$scope.findByuserId=function(page,rows){
        myInterviewService.findByuserId(page,rows).success(
		  		function(response){
		  		$scope.list=response.rows;
		  		$scope.paginationConf.totalItems=response.total;
		  		}
		);
	}

    $scope.dele=function(tbtitleId){
        myInterviewService.dele(tbtitleId).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();//刷新列表
                }else {
                    alert("失败");
				}
            }
        );
    }

    //批量删除
    $scope.deles=function(){
        //获取选中的复选框
        myInterviewService.deles( $scope.selectIds ).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();//重新加载
                }else {
                    alert("失败");
                }
            }
        );
    }

    //查询实体
    $scope.findone=function(tbtitleId){
        myInterviewService.findone(tbtitleId).success(
            function(response){
                $scope.entity=response;
                $scope.reloadList();
            }
        );
    }
    //保存
    $scope.save=function(){
       myInterviewService.update( $scope.entity ).success(
           function(response){
               if(response.status==200){
                   //重新查询
                   $scope.reloadList();//重新加载
               }else{
                   alert("失败");
               }
           }
       ); //修改

    }
});	

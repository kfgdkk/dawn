 //控制层
app.controller('category_uiController',function($scope,$controller,category_uiService){

	/*$controller('baseController',{$scope:$scope});//继承*/
    //重新加载列表数据
    $scope.reloadList=function(grade){
        //切换页码

            if(grade==1){
                $scope.findByparentId(171,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
                return;
            }


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


            $scope.reloadList($scope.grade);//重新加载
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
    //把json转换对象，提取里面的key值
    $scope.jsontoString=function(jsonstring,key){
        //把json转换成对象
        var list=JSON.parse(jsonstring);
        var str="";
        for(var i=0;i<list.length;i++){
            if(i>0){
                str+=",";
            }
            str+=list[i][key];
        }
        return str;
    }
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
        category_uiService.findAll().success(
			function(response){
				$scope.list=response;
			}
		);
	}

    //分页
    /*$scope.findPage = function(page, rows) {
	    if($scope.grade!=3){
            $http.get('../category/findPage.do?page=' + page + '&rows=' + rows).success(
                function(response) {
                    $scope.list = response.rows;
                    $scope.paginationConf.totalItems = response.total; //更新总记录数});\
                    //
                })
        }else {
            $http.get('../title/findPage.do?page=' + page + '&rows=' + rows).success(
                function(response) {
                    $scope.list = response.rows;
                    $scope.paginationConf.totalItems = response.total; //更新总记录数});\
                    //
                })
        }

	}*/

	//查询实体
	$scope.findOne=function(id){
        category_uiService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);
	}
    //查询详情--王成
    $scope.findOne3=function(id){
        category_uiService.findOne3(id).success(
            function(response){
                $scope.entity= response;
            }
        );
    }
    //查询详情--修改的题目
    $scope.findOne2=function(id){
        category_uiService.findOne2(id).success(
            function(response){
                $scope.entity= response;
            }
        );
    }
    //添加
    $scope.add=function(){
        $scope.entity.parentId=$scope.parentId;//获取当前页面父Id,
        //获取选中的复选框
        category_uiService.add( $scope.entity ).success(
            function(response){
                if(response.success){
                    //重新查询
                    alert("添加成功");
                    $scope.findByparentId($scope.entity.parentId,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载//重新加载
                }
            }
        );
    }
    //修改
    $scope.update=function(){
        //获取选中的复选框
        category_uiService.update( $scope.entity ).success(
            function(response){
                if(response.success){
                    //重新查询
                    alert("修改成功");
                    $scope.findByparentId($scope.parentId,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载//重新加载
                }
            }
        );
    }
	/*//保存
	$scope.save=function(){
		var serviceObject;//服务层对象
		if($scope.entity.categordId!=null){//如果有ID
			serviceObject=category_uiService.update( $scope.entity ); //修改
		}else{
			//在添加之前 要找到之前的父id
			$scope.entity.parentId=$scope.parentId;
			serviceObject=category_uiService.add( $scope.entity  );//增加
		}
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
                    alert("更改成功");
                    $scope.findByparentId($scope.parentId,$scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载//重新加载
				}
			}
		);
	}*/


	//批量删除
	$scope.dele=function(){
		//获取选中的复选框
        category_uiService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					//$scope.reloadList();//刷新列表
					$scope.findByparentId($scope.parentId,1,10);//重新加载
				}
			}
		);
	}

	$scope.searchEntity={};//定义搜索对象

	//搜索
	$scope.search=function(page,rows){
        category_uiService.search(page,rows,$scope.searchEntity).success(
			function(response){
                $scope.paginationConf.totalItems=response.total;//更新总记录数
				$scope.list=response.rows;

			}
		);
	}
	/**
	 * 根据父类id查询所有
	 */
	$scope.parentId=0;//定义父id为0
    $scope.page = $scope.paginationConf.currentPage;
    $scope.rows = $scope.paginationConf.itemsPerPage;
	$scope.findByparentId=function(parentId,page,rows){
		$scope.parentId=parentId;//记录id
        category_uiService.findByparentId(parentId,page,rows).success(
		  		function(response){
		  		    $scope.paginationConf.totalItems = response.total;
		  		$scope.list=response.rows;
		  		}
		);
	}
//定义一个级别变量
    $scope.grade=1;//级别为1
    $scope.setgrade=function(value){  //设置级别方法
        $scope.grade=value;
    }
    $scope.parentId=0;//定义父id为0
    $scope.findTitleList=function(parentId,page,rows){

        $scope.parentId=parentId;//记录id
        category_uiService.findTitleList(parentId,page,rows).success(
            function(response){
                $scope.paginationConf.totalItems = response.total;
                $scope.list=response.rows;
            }
        );
    }
    //定义一个变量来绑定实体
    $scope.selectList=function(p_entity){
       // console.info(p_entity+"=============");
       // alert(p_entity.classname);
        //1级目录判断
        if($scope.grade==1){
            $scope.page=1;
            $scope.rows=10;
            $scope.entity_1=null;
            $scope.entity_2=null;
            $scope.findByparentId(171,$scope.page,$scope.rows);
        }
        //2级目录判断
        if($scope.grade==2){

            $scope.page=1;
            $scope.rows=10;
            $scope.entity_1=p_entity;
            $scope.entity_2=null;
            $scope.findByparentId(p_entity.categordId,$scope.page,$scope.rows);
        }
        //3级目录判断
        if($scope.grade==3){

            $scope.page=1;
            $scope.rows=10;
            $scope.entity_2=p_entity;
            $scope.findTitleList(p_entity.categordId,$scope.page,$scope.rows);
        }
    }



});

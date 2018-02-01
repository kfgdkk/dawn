 //控制层 
app.controller('companyController' ,function($scope,$controller,companyService){
	
	$controller('companysController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
        companyService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){
        companyService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){
        companyService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
    $scope.entity={};//定义添加的面试题对象
    //给公司添加题目和答案(yz)
    $scope.saveTitleDesc=function(){

        companyService.saveTitleDesc($scope.entity)
            .success(
                function(response){
                    if(response.status==200){
                        //重新查询
                        alert("添加成功,等待审核中...");
                        $scope.reloadList();//重新加载
                    }else{
                        alert("添加失败!!!");
                    }
                }
            );
    }

	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.companyId!=null){//如果有ID
			serviceObject=companyService.updateCompany( $scope.entity ); //修改
		}else{
			//在添加之前 要找到之前的父id

			serviceObject=companyService.add( $scope.entity  );//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.findByparentId($scope.parentId);//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}

    //新增公司
    $scope.saveCompany=function (entity) {
        companyService.saveCompany(entity).success(
            function (response) {
                $scope.entity =response;
                alert("添加成功");
                //重新查询
                $scope.findjava(response);//重新加载
            }
        );
    }
    //删除公司del(entity.id)
    $scope.del=function(companyId){
		//获取id
        companyService.del(companyId).success(
            function(response){
                $scope.entity =response;
                //重新查询
                $scope.reloadList();///重新加载
            }
        );
    }
	 
	//批量删除公司
	$scope.dele=function(){			
		//获取选中的复选框			
        companyService.dele( $scope.selectIds ).success(
			function(response){
				$scope.entity =response;
                    alert("批量删除成功");
                    //重新查询
                    $scope.reloadList();///重新加载
			}		
		);				
	}

	//修改公司
	$scope.updateCompany=function () {
        //获取id
        companyService.updateCompany(companyId,corporate,companyinfo).success(
            function(response){
                $scope.entity =response;
                alert("修改成功");
                //重新查询
                $scope.reloadList();///重新加载
            }
        );

    }

	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search1=function(page,rows){
        companyService.search1(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    $scope.search2=function(page,rows){
        companyService.search2(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.search3=function(page,rows){
        companyService.search3(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    $scope.search4=function(page,rows){
        companyService.search4(page,rows,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
	/**
	 * 根据父类id查询所有
	 */
	$scope.parentId=0;//定义父id为0
	$scope.findByparentId=function(page,rows,parentId){
		$scope.parentId=parentId;//记录id
        companyService.findByparentId(page,rows,parentId).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
	}
    //定义一个级别变量
    $scope.grade=1;//级别为1
    $scope.setgrade=function(value){  //设置级别方法
        $scope.grade=value;
    }

    $scope.entity.companyId =0;//定义公司id
    $scope.entity_1 =null;//定义一个变量来绑定实体(当前点击的公司)
    var aaa = 0;//公司id
    $scope.selectList=function(page,rows,p_entity){
        if($scope.grade==2) {
            if (isNaN(p_entity)) {
                $scope.entity_1 = p_entity;
                aaa=p_entity.companyId;
            }else {
                aaa=p_entity;
            }
        }
        $scope.entity.companyId =aaa;
        $scope.findByparentId(page,rows,aaa);
    }


});

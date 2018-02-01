 //控制层 
app.controller('itemCatController' ,function($scope,$controller,itemCatService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=itemCatService.update( $scope.entity ); //修改  
		}else{
			//在添加之前 要找到之前的父id
			$scope.entity.parentId=$scope.parentId;
			serviceObject=itemCatService.add( $scope.entity  );//增加 
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
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		itemCatService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					//$scope.reloadList();//刷新列表
					$scope.findByparentId($scope.parentId);//重新加载
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		itemCatService.search(page,rows,$scope.searchEntity).success(
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
	$scope.findByparentId=function(parentId){
		$scope.parentId=parentId;//记录id
		itemCatService.findByparentId(parentId).success(
		  		function(response){
		  		$scope.list=response;
		  		}
		);
	}
	//定义一个级别变量
	$scope.grade=1;//级别为1
	 $scope.setgrade=function(value){  //设置级别方法
	 $scope.grade=value;	
	}
	
	 //定义一个变量来绑定实体
	$scope.selectList=function(p_entity){
        console.info(p_entity+"=============");
		//1级目录判断
		if($scope.grade==1){

			$scope.entity_1=null;
			$scope.entity_2=null;
		}
		//2级目录判断
		if($scope.grade==2){
			$scope.entity_1=p_entity;
			$scope.entity_2=null;
		}
		//3级目录判断
		if($scope.grade==3){
			$scope.entity_2=p_entity;
		}
	    $scope.findByparentId(p_entity.id);
	}
    
});	

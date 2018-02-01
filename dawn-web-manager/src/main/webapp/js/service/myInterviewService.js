//服务层
app.service('myInterviewService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../itemCat/findAll.do');		
	}


	//增加 
	this.add=function(entity){
		return  $http.post('../itemCat/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../background/zhl/title/update.do?title='+entity.title+'&tbtitleId='+entity.tbtitleId+'&titleDesc='+entity.titleDesc,entity );
	}
	//删除
	this.dele=function(tbtitleId){
		return $http.get('../background/zhl/title/deleteStudent.do?tbtitleId='+tbtitleId);
	}
    //pi删除
    this.deles=function(ids){
        return $http.get('../background/zhl/title/deleteStudents.do?ids='+ids);
    }
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../itemCat/search.do?page='+page+"&rows="+rows, searchEntity);
	}  
	//根据父类id查询所有
	this.findByuserId=function(page,rows){
		return $http.post('../background/zhl/title/auditStatus.do?page='+page+"&rows="+rows);
	}
    //根据题目id查询题目信息
    this.findone=function(tbtitleId){
        return $http.post('../background/zhl/title/findone.do?tbtitleId='+tbtitleId);
    }
});

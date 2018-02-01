//服务层
app.service('category_javaService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../itemCat/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../itemCat/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体--米源
	this.findOne=function(id){
		return $http.get('../findOne.do?id='+id);
	}
    //修改题目的回显--不知道谁的
    this.findOne2=function(id){
        return $http.get('../findOne2.do?id='+id);
    }
    //查询详情-王成
    this.findOne3=function(tbtitleId){
        return $http.get('../titledesc.do?tbtitleId='+tbtitleId);
    }
	//增加 
	this.add=function(entity){
		return  $http.post('../saveTree.do?parentId='+entity.parentId+'&classname='+entity.classname );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../updateTree.do?categordId='+entity.categordId+'&classname='+entity.classname );
	}
	//删除
	this.dele=function(selectIds){
		return $http.get('../itemCat/delete.do?ids='+selectIds);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../itemCat/search.do?page='+1+"&rows="+10, searchEntity);
	}  
	//根据父类id查询所有
	this.findByparentId=function(parentId,page,rows){
		return $http.post('../title/tree.do?categoryid='+parentId+'&page='+page+'&rows='+rows);
	}
    //叶子节点题目列表
    this.findTitleList=function (parentId,page,rows) {
        return $http.post('../title/list.do?categordId='+parentId+'&page='+1+'&rows='+10);
    }

});

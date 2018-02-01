//服务层
app.service('companyService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../itemCat/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../itemCat/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
        return $http.get('../background/company/findOne.do?id='+id);
	}
	//增加 java
	this.saveCompany=function(entity){
		return  $http.post('../background/saveCompany1.do?corporate='+entity.corporate+'&companyinfo='+entity.companyinfo);
	}
    //公司增加题目和答案
    this.saveTitleDesc=function(entity){
        return  $http.post('../background/company/add.do',entity );
    }
	//修改 
	this.update=function(entity){
		return  $http.post('../itemCat/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../itemCat/delete.do?ids='+ids);
	}
	//删除公司111
	this.del=function (companyId) {
		return $http.get('../background/company/delete.do?companyId='+companyId);
    }
    //批量删除公司111
    this.dele=function(selectIds) {
        return $http.get('../background/company/deleteMore.do?companyIds='+selectIds);
    }
    //修改公司
	this.updateCompany=function (companyId,corporate,companyinfo) {
		return $http.get('../background/company/updateCompany.do?companyId='+companyId+'&corporate='+corporate+'&companyinfo='+companyinfo);
    }
	//搜索(yz)
	this.search1=function(page,rows,searchEntity){
		return $http.post('../background/company/search.do?page='+page+"&rows="+rows+"&type=1", searchEntity);
	}
    this.search2=function(page,rows,searchEntity){
        return $http.post('../background/company/search.do?page='+page+"&rows="+rows+"&type=2", searchEntity);
    }
    this.search3=function(page,rows,searchEntity){
        return $http.post('../background/company/search.do?page='+page+"&rows="+rows+"&type=3", searchEntity);
    }
    this.search4=function(page,rows,searchEntity){
        return $http.post('../background/company/search.do?page='+page+"&rows="+rows+"&type=4", searchEntity);
    }

    //根据父类id查询所有
	this.findByparentId=function(page,rows,parentId){
		return $http.post('../background/company/findByParentId.do?page='+page+"&rows="+rows+'&parentId='+parentId+"&b="+Math.random());
	}

});

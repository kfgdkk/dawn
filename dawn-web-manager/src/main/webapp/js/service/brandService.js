//角色服务层
app.service('brandService',function($http){

//抽取查询的方法
    this.findAll=function(){
        return $http.get('../sysrole/findSysRoleAll.do');//业务逻辑层 service
    }

    //抽取删除的方法
    this.delete=function(delIds){
        return $http.get('../sysrole/deleteSysRole.do?delIds='+delIds);
    }
    //抽取添加的方法
    this.add=function(entity){
        return $http.post('../sysrole/addSysRole.do',entity)
    }
    //抽取修改的方法
    this.update=function(entity){
        return $http.post('../sysrole/updateSysRole.do',entity)
    }
    //抽取根据id查询
    this.findOne=function(id){
        return $http.get('../sysrole/findOne.do?id='+id);
    }
    //抽取条件查询分页方法
    this.search=function(page,rows,searchEntity){
        return $http.post('../sysrole/findSysRoleAll.do?page='+page+"&rows="+rows,searchEntity);
    }
    //抽取分页方法
    this.findPage=function(page,rows){
        return $http.get('../brand/findPage.do?page='+ page + '&rows=' + rows);
    }

    //下拉列表数据
    this.selectOptionList=function(){
        return  $http.get('../brand/selectOptionList.do');
    }

});
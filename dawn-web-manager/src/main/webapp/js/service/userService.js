app.service('userService',function($http){

    /*//抽取查询方法
    this.findAll=function(){
        return $http.get('../background/sysrole/findUserAll.do?page='+ page + '&rows=' + rows);
    }*/

    //抽取删除的方法
    this.delete=function(ids){
        return $http.get('../background/sysuser/delete.do?ids='+ids);
    }
    //抽取添加的方法
    this.add=function(roleId,entity){
        return $http.post('../background/sysuser/addUser.do?roleId='+roleId,entity);
    }
    //抽取修改的方法
    this.update=function(roleId,entity){
        return $http.post('../background/sysuser/update.do?roleId='+roleId,entity)
    }
    //抽取根据id查询
    this.findOne=function(id){
        return $http.get('../background/sysuser/findOne.do?id='+id);
    }
    //抽取条件查询分页方法
    this.search=function(page,rows,searchEntity){
        return $http.post('../background/sysuser/search.do?page='+page+"&rows="+rows,searchEntity);
    }
   ///抽取分页方法
    this.findPage=function(page,rows){
        return $http.get('../background/sysuser/findUserAll.do?page='+ page + '&rows=' + rows);
    }

    //下拉列表数据
    this.selectOptionList=function(){
        return  $http.get('../background/sysuser/selectOptionList.do');
    }

    this.findAll = function(page,rows){
        return $http.get('../background/sysuser/findUserAll.do?page='+ page + '&rows=' + rows);
    }
});

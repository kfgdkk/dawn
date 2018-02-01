//服务层  教师审核知识点自用js，请勿乱动及修改  李先生
app.service('tbTitleService',function($http){

    //分页
    this.findPage=function(page,rows,userid){
        return $http.get('../background/title/audit.do?page='+page+'&rows='+rows,userid);
    }

    //修改
    this.updateTbtitle=function(tbtitleId,cause){
        return  $http.post('../background/title/updated.do?tbtitleId='+tbtitleId +"&cause="+cause );
    }
    //批量修改
    this.dele=function(ids){
        return $http.get('../background/title/updateAll.do?ids='+ids);
    }
    //重复删除
    this.dele1=function(ids){
        return $http.get('../background/title/delete.do?ids='+ids);
    }
    //批量驳回
    this.upda=function(ids,cause){
        return $http.get('../background/title/updateAllNo.do?ids='+ids+"&cause="+cause);
    }

    //更改状态
    this.updateStatu=function(tbtitleId){
        return $http.post('../background/title/updateStatu.do?tbtitleId='+tbtitleId);
    }
});

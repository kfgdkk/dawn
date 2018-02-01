app.controller('companysController',function($scope){
    //定义一个类别变量
    $scope.types=1;//级别为1
    $scope.settypes=function(value){  //设置级别方法
        $scope.types=value;
    }
    //重新加载列表数据
    $scope.reloadList=function(){
        //切换页码
        if($scope.grade==2){
           // console.info("======$$$$$$$$$$$$$$$=======");
            $scope.selectList($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.entity_1.companyId);

        }else{
            //console.info($scope.types+"======%%%%%%%%%%%%%%%%=======");
            if($scope.types==1){
             $scope.search1($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);}
            if($scope.types==2){
                $scope.search2($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);}
            if($scope.types==3){
                $scope.search3($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);}
            if($scope.types==4){
                $scope.search4($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);}
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
    $scope.updateSelection=function($event,companyId){
        //判断如果被选中 添加到数组
        if($event.target.checked){
            $scope.selectIds.push(companyId);
        }else{
            //否则是移除   从数组中查找 从哪里开始移除
            var index=$scope.selectIds.indexOf(companyId);
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
});
/**
 * 用户管理
 */
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#articleList'
            ,url:'/QuerySpacetest'
            ,method: 'post' //默认：get请求
            ,cellMinWidth: 80
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {type:'numbers'}
                ,{field:'id', title:'ID',width:80, unresize: true, sort: true}
                ,{field:'comment', title:'标题'}
                ,{fixed:'right', title:'操作',width:140,align:'center', toolbar:'#optBar'}
            ]]
            ,  done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                //console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

       

    });
    
});

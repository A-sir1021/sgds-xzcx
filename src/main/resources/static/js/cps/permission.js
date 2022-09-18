/**
 * 用户管理
 */
var pageCurr;
$(function() {
    layui.use(['layer','table'], function(){
        var table = layui.table
            ,form = layui.form
            ,layer=layui.layer;

        tableIns=table.render({
            elem: '#permission'
            ,url:'/Permissiontest'
            ,method: 'post' //默认：get请求
            ,cellMinWidth: 80
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的 字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {type:'numbers'}
                ,{field:'id', title:'ID',width:80, unresize: true, sort: true}
                ,{field:'name', title:'姓名'}
                ,{field:'pid', title:'PID'}
                ,{field:'zindex', title:'Zindex'}
                ,{field:'istype', title:'IsType'}
                ,{field:'descpt', title:'descpt'}
                ,{field:'code', title:'code'}
                ,{field:'icon', title:'icon'}
                ,{field:'page', title:'page'}
                ,{field:'insert_time', title:'insert_time'}
                ,{field:'update_time', title:'update_time'}
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
        table.on('tool(userTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                delUser(data,data.id,data.name);
            } else if(obj.event === 'edit'){
                //编辑
                getUserAndRoles(data,data.id);
            } else if(obj.event === 'Query'){
                //恢复
                QueryUser(data,data.id);
            }
            
        });
        //监听提交
      /*  form.on('submit(userSubmit)', function(data){
            // TODO 校验
        	load(data);
            return false;
        });*/
      /* form.on('submit(ad)', function(data){
            // TODO 校验
        	alert(1);
        	Add();
        	 return false;
        });*/
       /* form.on('submit(query)', function(data){
            // TODO 校验
        	QueryById(data,data.id);
            return false;
        });*/
       /* form.on('submit("userSubmit")', function(data){
            // TODO 校验
        	Add(data,data.id,data.name,data.pid,data.zindex,data.istype,data.descpt,data.code,data.icon,data.page,data.insert_time,data.update_time);
            return false;
        });*/
        
    });
    //搜索框
 
});


//提交表单
/*function formSubmit(obj){
    var currentUser=$("#currentUser").html();
    if(checkRole()){
        if($("#id").val()==currentUser){
            layer.confirm('更新自己的信息后，需要您重新登录才能生效；您确定要更新么？', {
                btn: ['返回','确认'] //按钮
            },function(){
                layer.closeAll();
            },function() {
                layer.closeAll();//关闭所有弹框
                submitAjax(obj,currentUser);
            });
        }else{
            submitAjax(obj,currentUser);
        }
    }
}
*/

function delUser(obj,id,name) {
    var currentUser=$("#currentUser").html();
    //var version=obj.version;
    if(null!=id){
        if(currentUser==id){
            layer.alert("对不起，您不能执行删除自己的操作！");
        }else{
            layer.confirm('您确定要删除'+id+'用户吗？', {
                btn: ['确认','返回'] //按钮
            }, function(){
                $.post("/DeleteByName",{"id":id},function(data){
                    if(isLogin(data)){
                        if(data=="ok"){
                            //回调弹框
                            layer.alert("删除成功！",function(){
                                layer.closeAll();
                                //加载load方法
                                load(obj);//自定义
                            });
                        }else{
                            layer.alert(data,function(){
                                layer.closeAll();
                                //加载load方法
                                load(obj);//自定义
                            });
                        }
                    }
                });
            }, function(){
                layer.closeAll();
            });
        }
    }
}

/*function QueryById(obj,id,name) {
          			$.post("/queryByName",{"id":id});
                	layer.alert("跳转成功");
                	load(obj);
	$("#query").on(
			'click',
			function(){
				layer.prompt({
					title : '学号查询'
				}，function(val,index){
					layer.close(index);
					$.ajax({
						type : "POST",
						datatype : "json",
						url : "/queryByName",
						data : "id="+ val,
						contentType : "application/x-www-form-urlencoded",
						async : false,
						success : function(result){
							var r = JSON.stringify(result);
							layer.alert("学号:" + result["id"] + " 姓名:"
									+ result["name"] + " PID:"
									+ result["pid"] + " zindex:"
									+ result["zindex"] + "istype:" + result["istype"] + "descpt:" + result["descpt"] + "code:" + result["code"] + "icon:" + result["icon"] + "page:" + result["code"] + "insert_time:" + result["insert_time"] + "update_time" + result["update_time"], {
									title : '查询结果'
							});
							},
							error : function(result){
								layer.alert('查找失败',{
									icon : 5
								});
							}
						}
					});
				});
			})
}*/

function QueryById(obj,id,name) {
  // layer.alert("ok");
   layer.prompt({
	   title : 'ID查询'
   },function(val,index){
	   layer.close(index);
	   var serializeUrl = $("#userSearch").serializeArray();
       s=serializeUrl[0].value;
       alert("s="+s);
	   $ajax({
		   type : "POST",
			datatype : 'json',
			data : s,
			url : "queryByName",
			contentType : "application/json",
			data : JSON.stringify(s),
			async : true,
			processData: false, //需设置为false。因为data值是FormData对象，不需要对数据做处理
		    contentType: false, 
		   success : function(result) {
			   var r = JSON.stringify(result);
			   layer.alert("学号:" + result["id"] + " 姓名:"
						+ result["name"] + " PID:"
						+ result["pid"] + " zindex:"
						+ result["zindex"] + "istype:" + result["istype"] + "descpt:" + result["descpt"] + "code:" + result["code"] + "icon:" + result["icon"] + "page:" + result["page"] + "insert_time:" + result["insert_time"] + "update_time" + result["update_time"],{
				   title : '查询结果'
			   });
		   },
		   error : function(result){
			   layer.alert('查询失败',{
				   icon : 5
			   });
		   }
	   });
   });
}
/*function Add(data,id,name,pid,zindex,istype,descpt,code,icon,age,insert_time,update_time){
	layer.open({
		type : 1,
		skin : 'layui-layer-lan',
		area : ['600px,360px'],
		shadeClose : true,
		title : '添加学生记录',
		content : $('#bidderDiv')
	});
	$('#id').val("");
	$('#name').val("");
	$('#pid').val("");
	$('#zindex').val("");
	$('#istype').val("");
	$('#descpt').val("");
	$('#code').val("");
	$('#icon').val("");
	$('#page').val("");
	$('#insert_time').val("");
	$('#update_time').val("");
	$("#add").off("click").on("click",function(){
		var record = {
				id : $('#id').val(""),
				name : $('#name').val(""),
				pid : $('#pid').val(""),
				zindex : $('#zindex').val(""),
				istype ：$('#istype').val(""),
				descpt : $('#descpt').val(""),
				code : $('#code').val(""),
				icon : $('#icon').val(""),
				page ：$('#page').val(""),
				insert_time : $('#insert_time').val(""),
				update_time : $('#update_time').val("")
		}
		$.ajax({
			type : "POST",
			url : "/Addlogin",
			datatype : "text",
			contentType : "application/json",
			data : JSON.stringify(record),
			async : true,
			success : function(result){
				layer.alert('添加成功',{
					icon : 6
				});
			},
			error : function(result){
				layer.alert('添加失败',{
					icon : 5
				});
			}
		})
	});
}*/
function Add() {
		//layer.alert("ok");
	/*	layer.open({
		type : 1,
		area : [ '600px', '360px' ],
		 fixed:false,
	    resize :false,
		shadeClose : true, //点击遮罩关闭
		title : '添加学生记录',
		content : $('#bidderDiv1'),
		   end:function(){
	           
	        }
	});*/
	 
	 $("#add").on("click",function() {
		 var serializeUrl = $("#userSearch").serializeArray();
	      s=serializeUrl[0].value;
	    
		var id=serializeUrl[0].value;
	 	var name = serializeUrl[1].value;
	 	var pid =  serializeUrl[2].value;
		var zindex = serializeUrl[3].value;
		var istype  =serializeUrl[4].value;
		var descpt = serializeUrl[5].value;
		var code =serializeUrl[6].value;
		var icon = serializeUrl[7].value;
		var page = serializeUrl[8].value;
		var insertTimeStart = serializeUrl[9].value;
		var updateTimeStart = serializeUrl[10].value;
		$.ajax({
			type : "POST",
			datatype : 'json',
			data : {id:id,name:name,pid:pid,zindex:zindex,istype:istype,descpt:descpt,code:code,icon:icon,page:page,insertTimeStart:insertTimeStart,updateTimeStart:updateTimeStart},
			url : "Addlogin",
			contentType : "application/json",
			//data : JSON.stringify(record),
			async : true,
			processData: false, //需设置为false。因为data值是FormData对象，不需要对数据做处理
		    contentType: false, 
			success : function(data) {
				layer.alert('添加成功',{
					icon : 6
				});
			},
			error : function(data) {
				layer.alert('添加失败',{
					icon : 5
				});
			}
		})
	});
}
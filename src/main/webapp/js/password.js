$().ready(function(){
	Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

			  $('#pwd').datagrid({   
			    height:245,
                width: '100%',
			    fitColumns:true ,
			    singleSelect:true,
			    url:'../password/getall',    //控制数据库操作
			    striped:true,
			    toolbar: [{
					iconCls: 'icon-search',
					handler: function(){
						$('#search2').panel('expand');
						$('#search2').panel('setTitle','查询');
						$('#btn2').click(function(){
							var username=$('#name').val();
							username= $.trim(username) ;//去掉前后空格
							if(username==null||username==''||username=='undefined'){
								$('#pwd').datagrid('load',{//load 加载自动本地的 url
									  //这是传递的参数
								 });
								  $('#hidden2').html("查询信息不能为空！");
							}else{
								 $('#pwd').datagrid('load',{//load 加载自动本地的 url
									 username:username    //这是传递的参数
								 });
							}
						});  
					}
				},{
					iconCls: 'icon-cancel',
					handler: function(){
						var row=$('#pwd').datagrid('getSelected');
						if(row==null||row=='undefined'){
							   $.messager.alert('提示','请选中一条记录！','error');
						   }else{
							   $.messager.confirm('确认','您确认想要删除此记录吗？',function(r){    
								    if (r){    
								    	 $.get("../password/process", { method: "delete",pid:row.pid},
											        function(result){
											           if(result.isok=='ok'){
											        	 $('#pwd').datagrid('reload',{});
											        	 $.messager.alert('信息提示','删除成功！','info');
											          }
										});
								    }
								});
						   }



					}
				},{
					iconCls: 'icon-edit',
					handler: function(){
						var row=$('#pwd').datagrid('getSelected');
						if(row==null||row=='undefined'){
							   $.messager.alert('提示','请选中要使用的密码','error');
						   }else{
						   if(row.state=="未使用"){
							   $.messager.confirm('确认','您确认想要使用该密码吗？',function(r){
								    if (r){
								    	 $.get("../password/process", { method: "shiyong",pid:row.pid},
											        function(result){
											           if(result.isok=='ok'){
											        	 $('#pwd').datagrid('reload',{});
											        	 $.messager.alert('信息提示','使用成功！','info');
											          }
										});
								    }
								});
						   }


					}

					}
				}
				],
			      rownumbers:true,
			      pagination:true,
			      pagePosition:'bottom',
				  pageNumber:1,
				  pageSize:6,
				  pageList:[6,9,12,15],
			    columns:[[
					{
					    field:'pid',
					    title:'PID',
					    width:80,
					    align:'center',
					    hidden:true,
					    order:'asc'
					},
					{
					    field:'customerCid.cid',
					    title:'CID',
					    width:80,
					    align:'center',
					    hidden:true,
					    order:'asc',
					    formatter:function(value , rec){
                            /** @namespace rec.customerCid */
                            return rec.cid
					    }
					},
			        {
				        field:'customerCid.cname',
				        title:'公司名称',
				        width:140,
				        align:'center',
				      formatter:function(value , rec){
					    	return rec.customerCid.cname
					    }
			        },
			        {
				        field:'ppassword',
				        title:'客户密码',
				        width:110,
				        align:'center'
			        },
			        {
				        field:'psdate',
				        title:'密码起始日期',
				        width:80,
				        align:'center'
			        },

			        {
				        field:'ptimes',
				        title:'当前次数',
				        width:80,
				        align:'center'
				       /*  formatter: function(value,row,index){
				            if(value>=500){
				               return "<span style=color:red>"+value+"</span>" ;
				            }
				            else{
				              return value;
				            }
				        }  */
			        },
			        {
				        field:'ptype',
				        title:'密码类型 ',
				        width:80,
				        align:'center',
				        formatter: function(value,row,index){

								if (value=='超级密码'){
									return " <label style='color: red;'>"+value+"</label>";
								} else {
									return value;
								}
							}

			        },
			        {
				        field:'state',
				        title:'状态',
				        width:80,
				        align:'center'
			        }

			    ]]
			    ,
			    onLoadSuccess:function(data){
        $('.editcls').linkbutton({text:'使用',plain:true,iconCls:'icon-edit'});
          }
			 });
			$('.editcls').click(function(){
			$.messager.alert('温馨提示','请选择以后日期');
			});
	  $('#search2').panel({

		  title: '密码维护',
		  collapsed:true
		});



	  $('#window_revise').dialog({
		    title: '修改信息',
		    width: 400,
		    height: 298,
		    closed: true,
		    cache: false,
		    modal: true
		});
	  $('#psdate').datebox({

		  editable:false,
		  required:false,

		  onSelect:function(date){

		  	  if(date.Format("yyyy-MM-dd")<new Date().Format("yyyy-MM-dd")){  //new Date().toLocaleString().substring(0,new Date().toLocaleString().indexOf(" ",0)).replace((/-/g,'--')+
		  	  	$.messager.alert('温馨提示','请选择 [ '+new Date().Format("yyyy-MM-dd")+' ]以后日期');
		  	 	  $('#psdate').datebox('setValue', '');
		  	  	}

		  }

		});

	   $('#shengchen').click(function(){
	     var pa_cname=  $('#pa_cname').val();
	      var pa_psdate= $('#psdate').datebox('getValue');
	      var ptype= $('#ptype').combo('getValue');

	   	   if(pa_cname==''){
	   	   	$.messager.alert('温馨提示','请在[ 用户管理 ]选择公司名称');

	   	   }else if(pa_psdate==''){
	   	   	$.messager.alert('温馨提示','请输入密码起始日期');
	   	   }else{
	   	   	$.post("../password/doPass", { psdate:pa_psdate,ptype:ptype},
											function(result){

											    $('#ppassword').val(result);
										},'json');

	   	   }

	   });
	    $('#name').focus(function(){

		  $('#hidden2').html('');
	  });


	 /*$('#pgroup').combobox({
    	onSelect: function(record){
    		var pgroup= record.value;
    		  if(pgroup=='超级密码组'){
    		  	$('#ptype').combobox('setValue', '超级密码');
    		  }else{
    		  	$('#ptype').combobox('setValue', '普通密码');
    		  }




    }
});
*/

$('#pass_canel').click(function(){

   $('#pass_table input[name="cname"]').val('');
    $('#psdate').datebox('setValue', '');
   $('#pass_table input[name="ppassword"]').val('');
});

$('#pass_ok').click(function(){


   var cid= $('#pa_cid').val();
   var psdate=  $('#psdate').datebox('getValue');
   var pgroup= "";
   var ptype= $('#ptype').combo('getValue');
   var ppassword= $('#ppassword').val();

   if(ppassword==null||ppassword==''){
   	 $.messager.alert('信息提示','密码不能为空！','info');
   }else{
   	$.post("../password/doAddPass", {
   	cid:cid,psdate:psdate,pgroup:pgroup,
   	ptype:ptype,ppassword:ppassword
   	
   	},
		function(result){
			if(result=='ok'){
				$.messager.show({
					title:'消息提示',
					msg:'操作成功',
					timeout:2000,
					showType:'slide'
				});
				 $('#pwd').datagrid('reload',{});
				 
				   //$('#pa_cname').val('');
				    //$('#psdate').datebox('setValue','');	
				   $('#ppassword').val('');
				 
			}
			 else if(result=='repeat'){
				$.messager.alert('信息提示','指定日期的密码已生成！','info');
				}
				else
				{
				$.messager.show({
					title:'消息提示',
					msg:'操作失败',
					timeout:3000,
					showType:'slide'
				});
			}
			


	},'json');
   }
   
   
    
});
	  
    });
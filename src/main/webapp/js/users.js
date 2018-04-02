$().ready(function(){
			  $('#table').datagrid({   
			    height:245,
                width: '100%',
			    fitColumns:true ,
			    singleSelect:true,
			    url:'../customer/getall',    //控制数据库操作
			    striped:true,
			    onSelect:function(rowIndex, rowData){
			    	$('#pa_cid').val(rowData.cid); 
			        $('#pa_cname').val(rowData.cname);   
			    },
			    toolbar: [{
					iconCls: 'icon-search',
					handler: function(){
						$('#search').panel('expand');
						$('#search').panel('setTitle','查询');
						$('#btn').click(function(){
							var username=$('#username').val();
							username= $.trim(username) ;//去掉前后空格
							if(username==null||username==''||username=='undefined'){
								$('#table').datagrid('load',{//load 加载自动本地的 url
									  //这是传递的参数
								 });
								  $('#hidden').html("查询信息不能为空！");
							}else{
								 $('#table').datagrid('load',{//load 加载自动本地的 url
									 username:username    //这是传递的参数
								 });
							}
						});  
					}
				},{
					iconCls: 'icon-edit',
					handler: function(){//业务逻辑
						/* $('#table').datagrid('load',{}); */
						$('#search').panel('setTitle','修改');
						$('#search').panel('collapse');
						 $('#error').html("");
						/*  1.选择行 判断是否选中，
			                2.打开编辑框
			                3.提交或是取消
			                4.刷新页面，弹出修改成功
						*/
					var data=$('#table').datagrid('getSelected');//获取选中行对象
					   if(data==null||data=='undefined'){
						   $.messager.alert('提示','请选中一条记录！','error');



					   }
					    
					
					//----------------------------------------注入显示值
						    $('#cid').val(data.cid);
						    $('#cname').val(data.cname);//bug
						    $('#coname').val(data.coname);
						    $('#cophone').val(data.cophone);
						    $('#coaddress').val(data.coaddress);
						    $('#cotype').val(data.cotype);
						    $('#cosale').val(data.cosale);
						    $('#codate').datebox('setValue', data.codate);	
						    //$('#codate').val(data.codate);
						//-----------------------------------   
						    	 $('#window_revise').window('open');
						    	 $('#btn_canel').click(function(){// 每次open 就会新建一个window(bug)
						    	        $('#method').val('update');
									  $('#window_revise').window('close'); 
									
									  // document.location.reload();//最笨方法刷新本地页面 
								 });
						    	 $('#btn_ok').click(function(){
						    		 
						    		 
									  var cname = $('#cname').val();//bug
									 var coname =  $('#coname').val();
									 var cophone=   $('#cophone').val();
									 var coaddress=   $('#coaddress').val();
									  var cotype=  $('#cotype').val();
									  var cosale=  $('#cosale').val();
									   var codate= $('#codate').datebox('getValue');
									  
						    		 if(cname==null||cname==''||cname=='undefined'){
						    			 $('#error').html('友好提示： 公司名称 不能为空');
						    		 }else if(coname==null||coname==''||coname=='undefined'){
						    			 $('#error').html('友好提示： 客户名称 不能为空');
						    		 }else if(cophone==null||cophone==''||cophone=='undefined'){
						    			 $('#error').html('友好提示：客户联系方式  不能为空');
						    		 }else if(coaddress==null||coaddress==''||coaddress=='undefined'){
						    			 $('#error').html('友好提示： 客户地址 不能为空');
						    		 }else if(cotype==null||cotype==''||cotype=='undefined'){
						    			 $('#error').html('友好提示：控制柜类型 不能为空');
						    		 }else if(cosale==null||cosale==''||cosale=='undefined'){
						    			 $('#error').html('友好提示： 本公司销售人员 不能为空');
						    		 }else if(codate==null||codate==''||codate=='undefined'){
						    			 $('#error').html('友好提示:开工日期 不能为空');
						    		 }else{
						    			 $('#window_revise').window('close',false); 
						    			 
						    			 $('#method').val('update');
						    			 
						    			 $('#do_form').submit(); 
						    			
						    			
						   }
								 });
						  
					}
				},{
					iconCls: 'icon-add',
					handler: function(){
						 // 日期格式化
					/* 	$('#date').datebox({ 
							 fit:true,
					         required:true,
					         //editable:false,
					         formatter:function(date){
					        	    var y = date.getFullYear();
					        		var m = date.getMonth()+1;
					        		var d = date.getDate();
					        		return y+'年'+m+'月'+d+'日';
					         }
					    });  */
					    $('#window_revise').window('setTitle','添加信息');   
						 $('#window_revise').window('open');
						 $('#error').html("");
			    		   
			    		   $(":input").val("");
			    		   $('#codate').datebox('setValue', '');
				    	 $('#btn_canel').click(function(){// 每次open 就会新建一个window(bug)
							  $('#method').val('update');
				    	 	// document.location.reload();
				    	 	$('#window_revise').dialog('close'); 
							  
						//最笨方法刷新本地页面
							
							
						 });
				    	 $('#btn_ok').click(function(){
				    		 
				    		  var cname = $('#cname').val();//bug
								 var coname =  $('#coname').val();
								 var cophone=   $('#cophone').val();
								 var coaddress=   $('#coaddress').val();
								  var cotype=  $('#cotype').val();
								  var cosale=  $('#cosale').val();
								   var codate= $('#codate').datebox('getValue');
								  
					    		 if(cname==null||cname==''||cname=='undefined'){
					    			 $('#error').html('友好提示： 公司名称 不能为空');
					    		 }else if(coname==null||coname==''||coname=='undefined'){
					    			 $('#error').html('友好提示： 客户名称 不能为空');
					    		 }else if(cophone==null||cophone==''||cophone=='undefined'){
					    			 $('#error').html('友好提示：客户联系方式  不能为空');
					    		 }else if(coaddress==null||coaddress==''||coaddress=='undefined'){
					    			 $('#error').html('友好提示： 客户地址 不能为空');
					    		 }else if(cotype==null||cotype==''||cotype=='undefined'){
					    			 $('#error').html('友好提示：控制柜类型 不能为空');
					    		 }else if(cosale==null||cosale==''||cosale=='undefined'){
					    			 $('#error').html('友好提示： 本公司销售人员 不能为空');
					    		 }else if(codate==null||codate==''||codate=='undefined'){
					    			 $('#error').html('友好提示:开工日期 不能为空');
					    		 }else{
					    			 $('#window_revise').window('close',false); 
					    			 
					    			 $('#method').val('add');
					    			 
					    			 $('#do_form').submit(); 
					    			
					    			
					   }
				    		 
				    		 
						 });
					}
				},{
					iconCls: 'icon-cancel',
					handler: function(){
						var row=$('#table').datagrid('getSelected');
						if(row==null||row=='undefined'){
							   $.messager.alert('提示','请选中一条记录！','error');
						   }else{
							   $.messager.confirm('确认','您确认想要删除此记录吗？',function(r){    
								    if (r){    
								    	 $.get("../customer/process", { method: "delete",cid:row.cid},
											        function(result){
											           if(result.isok=='ok'){
											        	 $('#table').datagrid('reload',{});
											        	 $.messager.alert('信息提示','用户删除成功！','info');
											          }else{
											          	$.messager.alert('信息提示','该公司有关联的密码，无法删除！','info');
											         
											          }
										});
								    }    
								}); 
						   }
						
					
						
					}
				}],
			      rownumbers:true,
			      pagination:true,
			      pagePosition:'bottom',
				  pageNumber:1,
				  pageSize:6,
				  pageList:[6,9,12,15],
			    columns:[[ 
					{
					    field:'cid',
					    title:'ID',
					    width:80,
					    align:'center',
					    hidden:true,
					    order:'asc'
					},
			        {
				        field:'cname',
				        title:'客户公司名称',
				        width:80,
				        align:'center'
				      
			        },    
			        {
				        field:'coname',
				        title:'客户联系人名称',
				        width:80,
				        align:'center'
			        },    
			        {
				        field:'cophone',
				        title:'客户联系方式',
				        width:150,
				        align:'center'
			        },    
			        {
				        field:'coaddress',
				        title:'客户公司地址',
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
				        field:'cotype',
				        title:'控制柜类型 ',
				        width:80,
				        align:'center'
			        },
			        {
				        field:'cosale',
				        title:'本公司销售人员',
				        width:150,
				        align:'center'
			        },
			        {
				        field:'codate',
				        title:'登陆日期',
				        width:150,
				        align:'center'
			        }
			    ]]    
			 }); 
	  $('#panel').panel({    
				  width:"100%",    
				  height:"60%",    
				  title: 'PLC系统管理平台', 
				  maximizable:true,
				  collapsible:true,
				  tools: [{    
			      iconCls:'icon-exit',  
			        handler:function(){
			           $.messager.confirm('确认','您确认退出系统吗？',function(r){    
								    if (r){    
								    	 $.post("../user/exit",{},
											        function(result){
											        		$("#msg").css("display", "none");
											        	location.href = "../user/login";//location.href实现客户端页面的跳转
											        	  
								       	
										});
								    }    
								}); 
						   }
			        }]    
   
				});   
	  $('#search').panel({    
		  title: '用户管理', 		 
		  collapsed:true
		});  
	  $('#username').focus(function(){
		 // $('#username').val('');
		  $('#hidden').html('');
	  });
	  //修改字段
	 /*  $('#window_revise').window({    
		    width:500,    
		    height:360, 
		    closed:true,
		    closable:false,
		    modal:true ,
		    minimizable:false
		}); */
	
	  $('#window_revise').dialog({    
		    title: '修改信息',    
		    width: 400,    
		    height: 298,    
		    closed: true,    
		    cache: false,    
		    modal: true   
		});  
	  $('#codate').datebox({    
		  editable:false,
		  required:false 

		});  
	 
	  
    });
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta charset="UTF-8">
	
	
	 
	 <link rel="stylesheet" type="text/css" href="../jquery/jquery-easyui-1.2.6/themes/icon.css">
	 <link rel="stylesheet" type="text/css" href="../jquery/jquery-easyui-1.2.6/themes/default/easyui.css">
	 <script src="../jquery/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	 <script src="../jquery/jquery-easyui-1.2.6/jquery.easyui.min.js"></script> 
	  <script src="../jquery/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	  <script src="../js/users.js"></script>
	    <script src="../js/password.js"></script>
	
<style>

body {
    background-color: #f5f5f5;
}
</style>


</head>

 <body>
      
        <div id="panel" style="" align="left">
          <div id="search" class="easyui-panel"  style="width:800xp;height:80px;padding:10px;background:#fafafa;margin:0 auto;" >
               <label>按公司名称查询：</label>
               <input type="text" id="username" name="username" size="30"   />
               <a id="btn" class="easyui-linkbutton"  >查询</a>  
               &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp<lable id="hidden" style="color: red;"></lable>  
          </div> 
          <table id="table" ></table>  
          <br/>
           <div id="search2" class="easyui-panel"  style="width:800xp;height:80px;padding:10px;background:#fafafa;margin:0 auto;" >
               <label>按公司名称查询：</label>
               <input type="text" id="name" name="username" size="30"   />
               
               <a id="btn2" class="easyui-linkbutton"  >查询</a>  
               &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp<lable id="hidden2" style="color: red;"></lable> 
                   
          </div> 
         
            <table width="100%">
                <tr>
                <td width="70%" ><table id="pwd" ></table> </td>
                <td width="30%">
                 <div id="p" class="easyui-panel" title="密码生成工具"   
				        style="width:400px;height:245px;padding:10px;background:#fafafa;"   
				        data-options="iconCls:'icon-save',closable:true,    
				                collapsible:true,minimizable:true,maximizable:true">   
				    <table id='pass_table' cellSpacing=3 cellPadding=3>
				     <tr> <td><p><input type="hidden"  name="cid"  id="pa_cid" /></p> </td></tr>  
				     <tr> <td><label>公司名称：</label> </td><td><input type="text"  id="pa_cname"  name="cname" readOnly="true" /></td></tr>  
				     <tr> <td><label>密码生成日期：</label> </td> <td><input type="text" id="psdate"  name="psdate" style="width:152px;" /></td></tr>
				     <!--  <tr> <td><label>组数：</label></td><td><select id="pgroup" class="easyui-combobox" name="pgroup" style="width:152px;" 
				     editable='false'   required="true" disabled="true"    panelHeight='100px'  >   
															    <option value="第一组" >第一组</option>   
															     
															</select>  </td></tr>
															-->
				     <tr> <td><label>密码类型：</label></td><td>
				     <select id="ptype" class="easyui-combobox" name="ptype" style="width:152px;" 
				     editable='false'   required="true"      panelHeight='50px'   >   
															    <option value="普通密码" >普通密码</option>   
															    <option  value="超级密码" >超级密码</option>  
															     <option  value="重置密码" >重置密码</option>  
															</select> 
				     </td></tr>
				     <tr> <td><label>密码：</label></td><td><input type="text" id="ppassword" name="ppassword" readOnly="true"   />
				    	 &nbsp;<a id="shengchen" class="easyui-linkbutton"  >生成密码</a>  </td></tr>
				   
				       
				       <tr>
				
					        <td align="center" colspan="2" ><a id="pass_ok" class="easyui-linkbutton" >提交</a>
					        &nbsp;
					        <a id="pass_canel" class="easyui-linkbutton"  >重置</a> </td>
					        
					       
					   </tr>
				    </table> 
				</div> 
                
                </td>
                </tr>
            </table>
           
         </div>  
         
         
         
         <!-- 修改模块 -->
         <div id="window_revise">
         <div align="center">
		    <form action="../customer/process" name=form id="do_form" method="post"
              style="background-color: #e9f0f2;"   >
              <input type="hidden" id='is_revise' name="is_revise"  value='yes'  />
                   <input type="hidden" id="method" name='method' value='update'  />
                   <input type="hidden" id="cid" name='cid' value=''  />
				  <table >
				     <tr>
				        <td colspan="2" height="30" align="center" ><lable id="error" style="color:red" ></lable></td>
				     </tr>
					    <tr>
					       <td width="100">
						      
							     <label>客户公司名称：</label>
							  
					       </td>
					       <td  width="100">
					          <div>
						         <!-- 文本框的设置 -->
						      <input  type="text" id="cname" name='cname'  value='' size="20" />
					          </div>
					       </td>
					   </tr>
					   
					    <tr>
					       <td>
					       		
							     <label>客户联系人名称 ：</label>
							 
					       </td>
					       <td>
					           <div>
						          <input type="text" id="coname" name="coname" value='' size="20"   />
					          </div>
					       </td>
					    </tr> 
					    
					   <tr>
					       <td>
						      
							     <label>客户联系方式：</label>
							  
					       </td>
					       <td>
					          <div>
						         <!-- 文本框的设置 -->
						        <input type="text" id="cophone" name="cophone" value='' size="20" />
						     
					          </div>
					       </td>	       
					   </tr>
					   
					   <tr>
					       <td>
						       
							     <label>客户公司地址 ：</label>
							  
					       </td>
					       <td>
					          <div>
						         <!-- 文本框的设置 -->
						        <input type="text" id="coaddress" name="coaddress"   value='' size="20" />
						     
					          </div>
					       </td>
					   </tr>
					   
					   <tr>
					       <td>
						       
							     <label>控制柜类型 ：</label>
							   
					       </td>
					       <td>
					          <div>
						         <!-- 文本框的设置 -->
						        <input type="text" id="cotype" name="cotype" value=''  size="20" />
					          </div>
					       </td>
					   </tr>
					    <tr>
					       <td>
						       
							     <label>本公司销售人员：</label>
							   
					       </td>
					       <td>
					          <div>
						         <!-- 文本框的设置 -->
						        <input type="text" id="cosale" name="cosale" value=''  size="20" />
					          </div>
					       </td>
					   </tr> 
					   <tr>
					       <td>
						       
							     <label>登陆日期：</label>
							   
					       </td>
					       <td>
					          <div>
						         <!-- 文本框的设置 -->
						         
						         
						        <input type="text" id="codate" name="codate" value=''   style="width:152px;" />
					          </div>
					       </td>
					   </tr>
				     <tr>
					     <td>&nbsp</td>
					  </tr>
					   <tr>
				
					        <td align="right" ><a id="btn_ok" class="easyui-linkbutton" >确认</a> </td>
					        <td align="center"><a id="btn_canel" class="easyui-linkbutton"  >取消</a>  </td>
					       
					   </tr>
				     </table>      
                </form>
		</div>  
        </div>
             
      
              
        
  </body>
</html>

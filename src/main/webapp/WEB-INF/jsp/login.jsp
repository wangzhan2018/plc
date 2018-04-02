<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/user/login.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.1.1.js'/>"></script>
	<script src="<c:url value='/js/common.js'/>"></script>
	<%-- <script  src="<c:url value='/js/login.js'/>"></script> --%>
  
  <script type="text/javascript">
	   function changeCode()  {  
		   $("#vCode").attr("src","<c:url value='/user/code'/>?img="+new Date().getTime());
		 }  
  </script> 
  <script type="text/javascript">
  $(function() {
		/*
		 * 1. 让登录按钮在得到和失去焦点时切换图片
		 */
		
			
			var loginname = window.decodeURI("${cookie.loginname.value}");
			if("${requestScope.user.loginname}") {
				loginname = "${requestScope.user.loginname}";
			}
			$("#loginname").val(loginname);
		
		/*
		 * 2. 给注册按钮添加submit()事件，完成表单校验*/
		 $("#tijiao").click(function(){
			
				 $("#msg").text("");
				var bool = true;
				$(".input").each(function() {
					
					var inputName = $(this).attr("name");
				
					if(!invokeValidateFunction(inputName)) {
						bool = false;
					}
				}); 
				if( bool == true){
					$("#loginForm").submit();
				}
				 
					
				
				
			}); 
		
		 
		 
		/*
		 * 3. 输入框得到焦点时隐藏错误信息
		 */
		$(".input").focus(function() {
			
			$("#msg").css("display", "none");
			
			
			var inputName = $(this).attr("name");
			$("#" + inputName + "Error").css("display", "none");
		});
		
		/*
		 * 4. 输入框推动焦点时进行校验
		 */
		$(".input").blur(function() {
			var inputName = $(this).attr("name");
			invokeValidateFunction(inputName);
		})
	});


	/*
	 * 输入input名称，调用对应的validate方法。
	 * 例如input名称为：loginname，那么调用validateLoginname()方法。
	 */
	function invokeValidateFunction(inputName) {
		inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
		var functionName = "validate" + inputName;
		return eval(functionName + "()");	
	}

	/*
	 * 登录名校验
	 */
	function validateLoginname() {
		var bool = true;
		$("#loginnameError").css("display", "none");
		var value = $("#loginname").val();
		if(!value) {// 非空校验
			$("#loginnameError").css("display", "");
			$("#loginnameError").text("用户名不能为空！");
			bool = false;
		} else if(value.length < 3 || value.length > 20) {//长度校验
			$("#loginnameError").css("display", "");
			$("#loginnameError").text("用户名长度必须在3 ~ 20之间！");
			bool = false;
		}
		//alert("validateLoginname :"+bool);
		return bool;
	}

	/*
	 * 校验密码
	 */
	function validateLoginpass() {
		var bool = true;
		$("#loginpassError").css("display", "none");
		var value = $("#loginpass").val();
		if(!value) {// 非空校验
			$("#loginpassError").css("display", "");
			$("#loginpassError").text("密码不能为空！");
			bool = false;
		} else if(value.length < 3 || value.length > 20) {//长度校验
			$("#loginpassError").css("display", "");
			$("#loginpassError").text("密码长度必须在3 ~ 20之间！");
			bool = false;
		}
	//	alert("validateLoginpass :"+bool);
		return bool;
	}

	/*
	 * 校验验证码
	 */
	/*
	function validateVerifyCode() {
		var bool = true;
		$("#verifyCodeError").css("display", "none");
		var value = $("#verifyCode").val();
		if(!value) {//非空校验
			$("#verifyCodeError").css("display", "");
			$("#verifyCodeError").text("验证码不能为空！");
			bool = false;
		} else if(value.length != 4) {//长度不为4就是错误的
			$("#verifyCodeError").css("display", "");
			$("#verifyCodeError").text("验证码不正确！");
			bool = false;
		} else {//验证码是否正确
			$.ajax({
				cache: false,
				async: false,
				type: "POST",
				dataType: "json",
				data: { verifyCode: value},
				url: "../user/codeistrue",
				success: function(flag) {
					if(flag==false) {
						$("#verifyCodeError").css("display", "");
						$("#verifyCodeError").text("验证码不正确！");
						bool = false;					
					}
				}
			});
		}
		//alert("validateVerifyCode :"+bool);
		return bool;
	}
*/
</script>
  </head>
  <body>
	<div class="main">
	  <div style="height: 100px;"></div>
	  <div>
	    <div class="imageDiv"><img class="img" src="<c:url value='/images/zj.png'/>"/></div>
        <div class="login1">
	      <div class="login2">
            <div class="loginTopDiv">
              <span class="loginTop">会员登录</span>
              <span>
                <a href="<c:url value='regist.jsp'/>" class="registBtn"></a>
              </span>
            </div>
            <div>
              <form target="_top" action="<c:url value='loginspass'/>" method="post" id="loginForm">
                <input type="hidden" name="method" value="login" />
                  <table>
                    <tr>
                      <td width="50"></td>
                      <td><label class="error" id="msg">
                      <c:forEach items="${msg}" var="m">
                            <c:out value="${m}"></c:out>  <br />
                      </c:forEach>
                      </label></td>
                    </tr>
                    <tr>
                      <td width="50">用户名</td>
                      <td><input class="input" type="text" name="loginname" id="loginname" /></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginnameError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>密　码</td>
                      <td><input class="input" type="password" name="loginpass" id="loginpass"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginpassError" class="error"></label></td>
                    </tr>
                    <tr>
                      <!--  <td>验证码</td>
                      <td>
                        <input class="input yzm" type="text" name="verifyCode" id="verifyCode" value=""/>
                        <img id="vCode" src="<c:url value='/user/code'/>" onclick="changeCode()" />
                        <a href="javascript:changeCode();">单击换一张图片</a>
                        
                      </td>
                      -->
                    </tr>
                    <tr>
                      <td height="20px">&nbsp;</td>
                      <td><label id="verifyCodeError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td align="left">
                         <input type="button" id="tijiao"   style="background-image:url(../images/login1.jpg);height: 27;width: 92" /> 
                         
                     
                      </td>
                      
                          
                     
                      
                    </tr>																				
                 </table>
              </form>
            </div>
          </div>
        </div>
      </div>
	</div>
  </body>
</html>
	
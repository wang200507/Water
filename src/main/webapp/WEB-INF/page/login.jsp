<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="_ctx" value="${pageContext.request.contextPath}"></c:set>
<%  String name="";
	String code="";
	Cookie[] cookies=request.getCookies();
	if(cookies!=null && cookies.length>0){
		for(Cookie c : cookies){
			if(c.getName().equals("userName")){
				name=c.getValue();
			} else if(c.getName().equals("code")){
				code=c.getValue();
			}
		}
	}
	
	String version = Constants.VERSION;
	String loginDistribute = Constants.LOGIN_DISTRIBUTE;
	String versionTitle = Constants.VERSION_TITLE;
	if(versionTitle != null && versionTitle.trim().length() > 0){
		versionTitle = "("+versionTitle+")";
	} else {
		versionTitle ="";
	}
	Object error = request.getAttribute("loginType");
	Object loginMessage = request.getAttribute("loginMessage");
	boolean isError = "error".equals(String.valueOf(error));
	boolean isDupLogin = "dupLogin".equals(String.valueOf(error));
	Object userCode = request.getAttribute("code");
	Object userName = request.getAttribute("userName");
	Object password = request.getAttribute("password");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title id ="loginTitle">恒信集团ERP系统登陆</title>
<link rel="icon"  href="${_ctx}/resource/images/public/favicon_02.gif" type="image/x-icon"></link>
<script type="text/javascript" src="${_ctx}/resource/js/lib/jquery/jquery.js"></script>
<style type="text/css">
*{padding:0px;margin:0px;font-family:Tahoma, Helvetica, Arial, “\5b8b\4f53″, sans-serif;}
html {	height:100%;}
body {height:auto !important;width:100%;background-image:url(resource/images/public/erp_01.png);	background-repeat:no-repeat;background-position: center;background-size:cover;-moz-background-size:cover;	-webkit-background-size:cover;}
.logo{ margin:auto; text-align:center; height:200px; background:url(resource/images/public/login_logo-01.png) no-repeat; background-position:48%; }
.login_form{height:170px; position:relative; }
.login_form form{width:450px; height:175px; background-color:#fff; border-radius:10px; margin:auto; padding:10px 0;}
.login_form form p { width:100%; height:30px; position:relative; text-align:center; }
.login_form form p input { margin-left:20px; }
.login_form form div.pwd_class input { margin-left:-7px; }
.login_form form div.radio_class { border-bottom:none; }
.login_form form b { display:inline-block; width:130px; } 
.login_form form i { font-style:inherit; font-size:14px; } 
.login_form form > div{border-bottom:1px solid #D8D8D8; padding:10px 20px; position:relative; }
.login_form form div.pwd_class{ border-bottom:none; }
.login_form form > div > span{ display:inline-block; position:absolute; right:0; -border:1px solid #ccc; margin:7px 10px; font-size:13px; color:#fff; }
.login_form form > div > span.passwordFail{ right:12px; }
.login_form form > div:last-child{border-bottom:none;}
.login_form form > div >label{ font-size:24px; color:#5F5F5F; font-weight:bold;}
.login_form > p { width:400px; height:20px; color:#fff; position:relative; margin:auto; bottom:-15px; text-align:center; }
.text{ line-height:30px; width:160px; -height:24px; font-size:20px; color:#727272; border:1px solid #ddd; outline:none; padding:3px 0 3px 5px;}
.login_submit{ height:50px; text-align:center}
.submit{margin:auto; border:none; background-color:#3B5897;width:450px; position:relative; top: 80px;border-radius:10px; padding:10px 0; color:#fff; font-size:24px; box-shadow:2px 2px 2px #111; outline:none;}
.copyright{position:absolute; text-align:center; color:#000; font-size:14px; bottom:20px; width:100%; color:#fff}
.alert-danger{display:none; font-size:14px; text-align:center;height: 60px;left: 50%;margin: 0 auto 20px -214px;position: absolute;top: 260px;width: 425px; color:#fff; font-weight:bold;}
</style>
</head>
<body onkeydown="keyLogin();">
<div class="logo"></div>
<div class="login_form" id="login_form">
    		<form action="${_ctx}/login.do" method="post" name="loginForm" id="loginForm">
				<div>
                	<label><b>公司编码：</b><input type="text" value="<%=code %>" maxlength="20" name="code" class="text" autocomplete="off"></label>
                    <span>*公司编码不能为空！</span>
                </div>
				<div>
                	<label><b>用&nbsp;&nbsp;户&nbsp;名：</b><input type="text" value="<%=name %>" maxlength="20" name="userName" class="text" autocomplete="off" ></label>
                    <span>*用户名不能为空！</span>
                </div>
                <div class="pwd_class">
                <label><b>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b> <input type="password"  value="" maxlength="20" name="password" class="text" autocomplete="off" ></label>
                    <span class="passwordFail">*密码不能为空！</span>
                </div>
                <p>
					<button type="button" id="button" title="登录" class="submit" style="cursor: pointer;">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</button>
                </p>
                <input type="hidden" name="relogin" id="relogin" value="login" />
            </form>

			<p id="error_info" style="color: red;<%if(isError) { %>display: block;<%} else { %>display: none; <%} %>>"><%=loginMessage%></p>
			<c:if test="${param.fitOut=='1'}">
				<p style="color: red;">账号已在其它地方登陆! </p>
			</c:if>
			<p id="process_info" style="color: wihte;display: none;">正在处理中，请稍后...</p>
</div>
<div class="copyright">湖北恒信德龙实业有限公司 &copy; 版权所有   版本：<%=version%><font style="color: red;">&nbsp;<%=versionTitle%></font></div>
</body>
</html>
<script>
	
	var login = document.getElementById('button');
	var loginForm = document.getElementById('login_form');
	var loginValues = loginForm.getElementsByTagName('input');
	var loginFail = loginForm.getElementsByTagName('span');
	for( var i=0; i<loginValues.length; i++ ){
		loginValues[i].index = i;
		loginValues[i].onblur = function(){
			if( this.value != '' ){
				loginFail[this.index].style.color = '#fff';
			}
		}
	}
	
	login.onclick = function(){
		for( var i=0; i<loginValues.length; i++ ){
			if( loginValues[i].value == '' ){
				loginFail[i].style.color = '#f00';
				return;
			}
		}
		doLogin();
	};
	
	<%if(isDupLogin){%>
		if(confirm('<%=loginMessage%>')){
			$("#error_info").css("display","none");
			$("#process_info").css("display","block");
			document.loginForm.relogin.value="kickout";
			document.loginForm.code.value="<%=userCode%>";
			document.loginForm.userName.value="<%=userName%>";
			document.loginForm.password.value="<%=password%>";
			document.loginForm.submit();
		}
	<%}%>
	
	
	function keyLogin(){
		if (navigator.appName == "Microsoft Internet Explorer") {
			 keycode = event.keyCode;
		} else {
			 keycode = keyLogin.caller.arguments[0].which;
		}
		//回车键的键值为13
		if (keycode == 13) {
			for ( var i = 0; i < loginValues.length; i++) {
				if (loginValues[i].value == '') {
					loginFail[i].style.color = '#f00';
					return;
				}
			}
			
			doLogin();
		}
	}
	
	function doLogin() {
		var vvalue = document.loginForm.code.value;
		var vUserName = document.loginForm.userName.value;
		var vPassword = document.loginForm.password.value;
		if(checkStr( vvalue ) || checkStr( vUserName ) ){
	   		$("#error_info").css("display","block");
	   		$("#error_info").html("输入信息存在特殊字符.");
	   		return false;
		}
		
	    <%if(Boolean.valueOf(loginDistribute)) {%>
			$("#error_info").css("display","none");
			$("#process_info").css("display","block");
			var loginUrl = getLoginUrl();
			if(loginUrl == null || loginUrl ==''){
			    $("#error_info").html("用户名或密码不正确，请重新输入！");
				$("#error_info").css("display","block");
				$("#process_info").css("display","none");
				return false;
			}
		    document.loginForm.action = loginUrl;
		<%} %>
		
		$("#error_info").css("display","none");
		$("#process_info").css("display","block");
		document.loginForm.submit();
	}
	
	function getLoginUrl(){
		var url = "";
		var vcode = document.forms[0].code.value;
		$.ajax({
			"type" : 'post',
			"url" : '${_ctx}/getUrl.do',
			"dataType" : "json",
			"async" : false,
			"data" : {entityCode:vcode},
			"success" : function(data) {
				if(data.resultCode == 0){
					url = data.resultMessage;
				}
			},
			error : function(data) {
				$("#process_info").css("display","none");		
			}
		});
		return url;
	}
	
	function checkStr(s) {
	    var pattern = new RegExp("[`%~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）—|{}【】‘；：”“'。，、？]")
		var rs = pattern.test(s);
	    return rs;
	}
	
	//F5功能
	function f5(event){
       with (event){
          if (keyCode==116 ){
			 window.location.reload();
          }
       }
    }
    document.onkeydown = f5;	
	
</script>
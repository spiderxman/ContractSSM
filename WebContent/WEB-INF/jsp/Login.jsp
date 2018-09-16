<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<HEAD>
<TITLE>ログイン</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="./css/Index.css">
<LINK rel=stylesheet type=text/css href="./css/Style.css">
<META name=GENERATOR content="MSHTML 9.00.8112.16476">
<script language="JavaScript">
 function submit(){
	 if(!inputCheck()){
		 return;
	 }
	document.login_form.submit();
	 }
 function reset(){
		document.login_form.reset();
		 }
 
 function inputCheck(){
	 var userId = document.getElementById("txtUserId").value;
	 var password = document.getElementById("txtPassword").value;
	 if(userId==null||userId==''){
		 document.getElementById("msg").innerHTML = "用户名不能为空";
		 return false;
	 }
	 if(password==null||password==''){
		 document.getElementById("msg").innerHTML = "密码不能为空";
		 return false;
	 }
	 return true;
 }
</script>
</HEAD>
<BODY class=IndexPage>
  <DIV style="BACKGROUND-IMAGE: url(Image/login.jpg); POSITION: relative; WIDTH: 100%; BACKGROUND-REPEAT: no-repeat; HEIGHT: 750px; OVERFLOW: auto">
	  <DIV style="POSITION: relative; MARGIN-TOP: 80px; WIDTH: 400px; FLOAT: left; MARGIN-LEFT: 20px">
	      <DIV style="WIDTH: 325px; HEIGHT: 40px" id=SystemMessage class=panelGrid>
	        <FIELDSET>
		        <LEGEND>システム情報 </LEGEND>
		            
		        	<SPAN style="COLOR: red" id=lblErrorMessage class=MsgStyle></SPAN>
		        </FIELDSET>
	      </DIV>
	   </DIV>
	<form name="login_form" action="Login1" method="post">
	  <DIV style="POSITION: relative; MARGIN: 326px 0px 0px 440px; WIDTH: 380px; HEIGHT: 180px">
	      <DIV style="WIDTH: 100%; HEIGHT: 50px">
	        <DIV style="POSITION: absolute; MARGIN-TOP: 32px; WIDTH: 120px; FLOAT: left; left: 9px; top: 4px;">
	        	<SPAN style="DISPLAY: inline-block; HEIGHT: 17px" id=lblUserId class=login-lbl>ユーザーID</SPAN> </DIV>
	        <DIV style="MARGIN-TOP: 30px; WIDTH: 250px; FLOAT: right">
	          <INPUT id=txtUserId name=userId style="BORDER-BOTTOM: #e4e4e4 1px solid; BORDER-LEFT: #e4e4e4 1px solid; 
	          BACKGROUND-COLOR: #f7f7f7; WIDTH: 179px; BORDER-TOP: #e4e4e4 1px solid; BORDER-RIGHT: #e4e4e4 1px solid">
	        </DIV>
	      </DIV>
	   <DIV style="WIDTH: 100%; HEIGHT: 50px">
	   		<DIV style="POSITION: absolute; MARGIN-TOP: 20px; WIDTH: 120px; FLOAT: left; left: 10px; top: 54px;">
	   		<SPAN style="DISPLAY: inline-block; HEIGHT: 20px" id=lblPassword class=login-lbl>パスワード</SPAN> </DIV>
		        <DIV style="MARGIN-TOP: 15px; WIDTH: 250px; FLOAT: right">
		          <INPUT id=txtPassword name=password style="BORDER-BOTTOM: #e4e4e4 1px solid; BORDER-LEFT: #e4e4e4 1px solid; 
		          BACKGROUND-COLOR: #f7f7f7; WIDTH: 179px; BORDER-TOP: #e4e4e4 1px solid; 
		          BORDER-RIGHT: #e4e4e4 1px solid" type=password>
		        </DIV>
	      	</DIV>
	      	<br>
	      	<div id="msg" style="width: 100%;text-align:center;font-family:verdana;font-size:16px;color:#FF0000">
	      		${message}
	      	</div>
	      	<DIV style="WIDTH: 100%; HEIGHT: 50px">
		        <DIV style="POSITION: absolute; MARGIN-TOP: 15px; WIDTH: 160px; FLOAT: left">
		        	<A href="javascript:void(0);" id="idsubmit" onclick="submit()">
		        	<img src="Image/login-dl.gif" style="BORDER-RIGHT-WIDTH: 0px; FLOAT: right; 
		        	BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px" /> </A>
		        </DIV>
		        <DIV style="MARGIN-TOP: 15px; WIDTH: 160px; FLOAT: right">
		          <A href="javascript:void(0);" id="idreset" onclick="reset()"><img style="BORDER-RIGHT-WIDTH: 0px; 
		          BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px" id=btnCancel name=btnCancel src="Image/login-qx.gif"/></A>
		        </DIV>
	    	</DIV>
	    </DIV>
    </form>
  </DIV>
</BODY>
</html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ検索</title>
<SCRIPT language=javascript type=text/javascript>
    var timeClient = new Date();

    function openHelpDoc() {
        window.open('Help/List.htm', 'newwindow', 'width=800,height=700,scrollbars=yes,resizable=yes,location=yes');
        return false;
    }
    function show(id){
        document.getElementById(id).style.display='block';
    }
    function hide(id){
        document.getElementById(id).style.display='none';
    }

    
    var timeClient = new Date();
    function getTimeSub() {
        var strTimeServer;
        var timeServer;
        if (document.getElementById('ctl00_hidTime') != null) {
            strTimeServer = document.getElementById('ctl00_hidTime').value;
            timeServer = new Date(strTimeServer);
        }
        var timeSub = Math.round((timeServer.getTime() - timeClient.getTime()) / 1000);
        return timeSub;
    }
    function getTime(n) {
        var clientTime = new Date();
        clientTime.setTime(clientTime.getTime() + n * 1000);
        var nowTime = clientTime.toLocaleDateString() + " " + clientTime.toLocaleTimeString();
        if (document.getElementById('ctl00_lblTime') != null) {
            document.getElementById('ctl00_lblTime').innerText = nowTime;
        }
        setTimeout("getTime(getTimeSub())", 1000);
    }
    function openHelpDoc() {
        window.open('Help/List.htm', 'newwindow', 'width=800,height=700,scrollbars=yes,resizable=yes,location=yes');
        return false;
    }
    function show(id){
        document.getElementById(id).style.display='block';
    }
    function hide(id){
        document.getElementById(id).style.display='none';
    }
    
    function userSearch(){
    	var form = document.getElementById("userSearchForm");
    	form.submit();
    }
</SCRIPT>
</head>
<BODY>
<DIV style="WIDTH: 1158px; HEIGHT: 150px">
<jsp:include page="../Header.jsp"/>
</DIV>
<FORM id="userSearchForm" style="TEXT-ALIGN: center" method=post action="UserSearch">
<DIV style="WIDTH: 1158px; HEIGHT: 30px">
    <DIV style="BACKGROUND-IMAGE: url(./Image/006.jpg); TEXT-ALIGN: left; MARGIN-TOP: 0px; TEXT-INDENT: 20px; WIDTH: 55%; BACKGROUND-REPEAT: no-repeat; FLOAT: left; HEIGHT: 28px"><SPAN
        id=ctl00_lbltitle class=title>ユーザー検索</SPAN>
    </DIV>
</DIV>
<DIV style="TEXT-ALIGN: left; WIDTH: 1158px">
<DIV class=tbTitile><SPAN id=ctl00_mainContent_SearchText
    class=inputlbl>検索条件</SPAN>
</DIV>
<DIV class=tbContent>
    <TABLE style="WIDTH: 100%" cellSpacing=0 cellPadding=0>
        <TBODY>
            <TR>
                <TD style="WIDTH: 170px"><SPAN id=ctl00_mainContent_lblUserCode
                    class=inputlbl>ユーザーID</SPAN><BR>
                <INPUT id=userId class=inputText
                    name="userId" maxLength=10></TD>
                <TD style="WIDTH: 170px"><SPAN id=ctl00_mainContent_lblUserName
                    class=inputlbl>ユーザー名</SPAN><BR>
                <INPUT id=userName class=inputText
                    name="userName" maxLength=20></TD>
                <TD style="WIDTH: 170px"><SPAN id=ctl00_mainContent_lblAcessGrp
                    class=inputlbl>権限</SPAN><BR>
                <SELECT id=ctl00_mainContent_ddlAcessGrp class=ddlBlack
                    name="userRoot">
                    <OPTION selected value=""></OPTION>
                    <OPTION value=admin>admin</OPTION>
                    <OPTION value=DEQXZ>事務担当者</OPTION>
                    <OPTION value=XSCG>販売担当者</OPTION>
                    <OPTION value=ZJL>総経理</OPTION>
                </SELECT></TD>
                <TD><BR>
                <SPAN style="WIDTH: 133px; DISPLAY: inline-block" class=chkBox>
                <INPUT id=delFlag name=delFlag type=checkbox>
                    <LABEL for=ctl00_mainContent_chkVisible>削除フラグ含む</LABEL></SPAN>
                </TD>
                <td>
                	<a class="btn btn-default" href="javascript:void(0);" role="button" onclick="userSearch();">検索</a>
                </td>
            </TR>
        </TBODY>
    </TABLE>
</DIV>
<DIV style="TEXT-ALIGN: center; WIDTH: 100%;">
	 ページ情報 
</DIV>

<!-- ユーザ検索結果一覧 -->
<DIV style="HEIGHT: 400px" class=gvContent>
<c:if test="${userInfoList.size() > 0}">
<DIV>
<TABLE style="WIDTH: 100%; BORDER-COLLAPSE: collapse"
    id=ctl00_mainContent_gvList border=1 rules=all cellSpacing=0
    cellPadding=0 class="table table-hover">
    <TBODY>
        <TR class=gvHeader>
            <TH style="WIDTH: 8%" scope=col>操作</TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$ユーザID')">ユーザID</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$ユーザー名')">ユーザー名</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$権限')">権限</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$削除状態')">削除フラグ</A></TH>
            <TH style="WIDTH: 14%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$電話番号')">電話番号</A></TH>
            <TH style="WIDTH: 14%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$メールアドレス')">メールアドレス</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$作成者')">作成者</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$作成日')">作成日</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$更新者')">更新者</A></TH>
            <TH style="WIDTH: 8%" scope=col><A
                href="javascript:__doPostBack('ctl00$mainContent$gvList','Sort$更新日')">更新日</A></TH>
        </TR>
        <c:forEach var="userInfo" items="${userInfoList }">
        	<TR
            	onclick="if(window.oldtr!=null){window.oldtr.runtimeStyle.cssText='';}this.runtimeStyle.cssText='background-color:#CCCCFF';window.oldtr=this;">
            	<TD style="WIDTH: 8%" align=center><A
                	id=ctl00_mainContent_gvList_ctl02_lnkEdit href="UserUpdate.htm">編集</A>
            	</TD>
            	<TD style="WIDTH: 8%" align=center><A
                	style="TEXT-DECORATION: underline"
                	id=ctl00_mainContent_gvList_ctl02_lnkUserID 
                	href="UserDetail.htm">${userInfo.userId}</A>
            	</TD>
            	<TD style="WIDTH: 8%" align=left>${userInfo.userName}</TD>
            	<TD style="WIDTH: 8%" align=left>${userInfo.authorityCd}</TD>
            	<TD style="WIDTH: 8%" align=center><SPAN title=削除フラグ disabled><INPUT
                	id=delFlag 
                	name=delFlag type=checkbox></SPAN></TD>
            	<TD style="WIDTH: 14%" align=left>${userInfo.telNumber}</TD>
            	<TD style="WIDTH: 14%" align=left>${userInfo.mailAddress}</TD>
            	<TD style="WIDTH: 8%" align=left>${userInfo.createUser}</TD>
            	<TD style="WIDTH: 8%" align=left>${userInfo.createDate}</TD>
            	<TD style="WIDTH: 8%" align=left>${userInfo.updateUser}</TD>
            	<TD align=left>${userInfo.updateDate}</TD>
        	</TR>
        </c:forEach>

    </TBODY>
</TABLE>
</DIV>
</c:if>
</DIV>

<INPUT id=ctl00_hidTime name=ctl00$hidTime value=2014/02/17 15:08:36 type=hidden />
</DIV>
</FORM>
<!-- フッター -->
<jsp:include page="../Footer.jsp"/>
</BODY>
</HTML>
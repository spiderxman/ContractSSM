<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン画面</title>
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

</SCRIPT>
</head>
<body onload="getNow('ctl00_lblTime');">
<jsp:include page="Header.jsp"/>
    <FORM style="TEXT-ALIGN: center" id=mainForm method=post name=mainForm action="Login">
        <DIV style="WIDTH: 1158px; HEIGHT: 30px">
            <DIV style="BACKGROUND-IMAGE: url(Image/006.jpg); TEXT-ALIGN: left; MARGIN-TOP: 60px; TEXT-INDENT: 20px; WIDTH: 65%; BACKGROUND-REPEAT: no-repeat; FLOAT: left; HEIGHT: 28px">
                <SPAN id=ctl00_lbltitle class=title>メイン画面</SPAN>
            </DIV>
        </DIV>
        <DIV style="TEXT-ALIGN: left; WIDTH: 1158px">
            <DIV style="WIDTH: 100%" id=ctl00_mainContent_MsgInfo class=panelGrid></DIV>
            <DIV style="TEXT-ALIGN: right; MARGIN-TOP: 8px; WIDTH: 100%; HEIGHT: 400px"></DIV>
            
            <INPUT id=ctl00_hidTime name=ctl00$hidTime value=2014/02/18 16:07:51 type=hidden>
        </DIV>
    </FORM>
<!-- フッター -->
<jsp:include page="Footer.jsp"/>
</body>
</html>
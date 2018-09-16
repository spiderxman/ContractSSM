<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン画面</title>
<link rel="stylesheet" type="text/css" href="./css/Index.css" />
<link rel="stylesheet" type="text/css" href="./css/Style.css" />
</head>
<body onload=getTime(getTimeSub());>
<SCRIPT language=javascript type=text/javascript>
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

</SCRIPT>
<DIV style="TEXT-ALIGN: center">
    <DIV style="BACKGROUND-IMAGE: url(Image/bj.jpg); WIDTH: 1250px; BACKGROUND-REPEAT: repeat-x">
        <DIV style="BACKGROUND-IMAGE: url(Image/top.jpg); TEXT-ALIGN: left; MARGIN: auto; WIDTH: 92%; BACKGROUND-REPEAT: no-repeat; HEIGHT: 82px">
            <DIV class=UserNotice>
                <DIV style="WIDTH: 50%; FLOAT: left">
                    <SPAN id=ctl00_lblUserID>ユーザー名：</SPAN><SPAN id=ctl00_lblUserName>
                   
                   Admin
                   </SPAN> &nbsp; <SPAN id=ctl00_lblTime></SPAN>
                </DIV>
                <DIV style="WIDTH: 50%; FLOAT: left">
                    <A id=ctl00_lnkHelp class=LogHelp onClick="return openHelpDoc();" href="javascript:__doPostBack('ctl00$lnkHelp','')">ヘルプ</A>
                    <A id=ctl00_lnkReturn class=LogReturn href="MainMenu.htm">メイン画面</A> 
                    <A id=ctl00_lnkExit class=LogExsit href="login.htm">ログアウト</A> 
                </DIV>
            </DIV>
        </DIV>
    </DIV>
    <div id="ddst" class="ddst">
        <ul id="nav" style="BACKGROUND-IMAGE: url(Image/001.jpg); PADDING-LEFT: 3%; WIDTH: 1250px; BACKGROUND-REPEAT: repeat-x">
            <li onMouseOver="show('nav_1');" onMouseOut="hide('nav_1')" ><a href="#">販売契約</a>
                <ul id="nav_1">
                    <li><a href="Sale/SaleContractSearch.htm">販売契約検索</a></li>
                </ul>
            </li>
            <li onMouseOver="show('nav_2');" onMouseOut="hide('nav_2')" ><a href="#">基本情報</a>
                <ul id="nav_2">
                    <li><a href="User/UserSearch.htm">ユーザー検索</a></li>
                </ul>
            </li>
            <li onMouseOver="show('nav_3');" onMouseOut="hide('nav_3')" ><a href="#">マスタ情報</a>
                <ul id="nav_3">
                    <li><a href="Master/BankAdd.htm">銀行</a></li>
                    <li><a href="Master/StatusAdd.htm">ステータス</a></li>
                    <li><a href="Master/PaymentAdd.htm">支払方法</a></li>
                    <li><a href="Master/UnitAdd.htm">単位</a></li>
                    <li><a href="Master/PortAdd.htm">地点</a></li>
                    <li><a href="Master/CurrencyAdd.htm">通貨種別</a></li>
                    <li><a href="Master/TradeLanAdd.htm">貿易用語</a></li>
                    <li><a href="Master/RootAdd.htm">権限</a></li>
                </ul>
            </li>
            <li class="yy"></li>
        </ul>
    </div>
</DIV>
    <FORM style="TEXT-ALIGN: center" id=aspnetForm method=post name=aspnetForm action=MainPage.sss>
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
    
<DIV id=CopyRight class=CopyRight><SPAN id=ctl00_rightPage>Wuxi NTT DATA Co., Ltd.</SPAN> </DIV>
</body>
</html>
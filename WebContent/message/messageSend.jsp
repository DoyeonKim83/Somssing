<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>���� ������</title>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
	font-family: 'Nanum Gothic', sans-serif;
}
	body{
		font-family: 'Nanum Barun Gothic', sans-serif;
	}
	#submit, #cancel, #re_list, #se_list{
		border-radius : 30px;
		background-color : #f0b3c1;
		color : #FFFFFF;
	}
</style>
</head>
<body>
	<div align="center">����������</p>
	<hr>
	<form action="<c:url value='/message/messageSend'/>" accept-charset="UTF-8" name="messageSend" method="GET">
	�޴»��: <input type="text" name = "receiver_id" size="12" value = "${recv_id}" required readOnly > <br>
	����: <p><textarea cols="50" rows="10" name = "msg_content"></textarea></p>
	
	
	<input type="submit" id="submit" value="����" >
	<input type="button" id="cancel" value="���" onclick="history.back()">
	<input type="button" id="re_list" value="�����������" onClick="location.href='<c:url value='/message/messageReceive' />'">
	<input type="button" id="se_list" value="�����������" onClick="location.href='<c:url value='/message/messageSent' />'">
	</form>
	</div>
</body>
</html>
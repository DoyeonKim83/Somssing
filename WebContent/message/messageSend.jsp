<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>쪽지 보내기</title>
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
	<p align="center">쪽지보내기</p>
	<hr>
	<form action="<c:url value='/message/messageSent'/>" name="messageSend" method="POST">
	받는사람: <input type="text" name="receiver" size="12"><br>
	내용: <p><textarea cols="50" rows="10"></textarea></p>
	
	
	<input type="submit" id="submit" value="전송" >
	<input type="button" id="cancel" value="취소">
	<input type="button" id="re_list" value="받은쪽지목록" onClick="location.href='<c:url value='/message/messageReceive' />'">
	<input type="button" id="se_list" value="보낸쪽지목록" onClick="location.href='<c:url value='/message/messageSent' />'">
	</form>
</body>
</html>
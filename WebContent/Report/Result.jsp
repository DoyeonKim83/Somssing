<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접수 완료</title>
</head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
#Btn {
            width : 250px;
            height : 80px;
            border : 1px solid  #ab2948;
            background-color :  #ab2948;
            color : #FFFFFF;
            border-radius : 30px;
         }
</style>
<body>
<div align="center" style="padding:100px 0px 0px 0px">
<h1>^o^<br>접수가 완료되었습니다</h1>
<br><br>
<button id="Btn" onclick="location.href='<c:url value='/main'/>'">메인페이지로 돌아가기</a>
</div>
</body>
</html>
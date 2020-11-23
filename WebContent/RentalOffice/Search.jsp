<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여소 검색</title>
</head>
<body>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
#Btn {
            width : 250px;
            height : 100px;
            border : 1px solid  #ab2948;
            background-color :  #ab2948;
            color : #FFFFFF;
            border-radius : 30px;
         }
         
</style>
<div align="center">
<h2>대여소 검색하기</h2>
</div>
<br><br>

<div align="center" >

<div>
<button id="Btn" onclick="location.href='<c:url value='/search/choice/area'/>'">
지역별 모아보기
</button></div>
<br><br>

<div>
<button id="Btn" onclick="location.href='<c:url value='/search/choice/id'/>'">
대여소 아이디로 검색
</button></div>
<br><br>

<div>
<button id="Btn" onclick="location.href='<c:url value='/search/choice/name'/>'">
대여소 이름으로 검색
</button></div>

</div>


</body>
</html>
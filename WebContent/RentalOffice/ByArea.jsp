<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
</style>
<meta>
<title>대여소 지역별 모아보기</title>
</head>
<body>
<div align="center">
<h1>지역별 검색</h1>
</div>
<div align="center"><br><br>
   <form action="<c:url value='/search/rentalOffice/ByArea' />" 
   name="SearchByArea" method="POST">
   &nbsp;&nbsp;
   <input type="text" name="area">&nbsp;&nbsp;
   <input type="submit" value="검색" style="background-color:#ab2948;
   border-radius:30px; color:#FFFFFF;"/></form>
   <br><br><br>
   <div>검색어 추천 : 성북구, 강북구, 강남구, 강서구, 강동구</div>
   
</div>

</body>
</html>
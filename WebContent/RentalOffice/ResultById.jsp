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
<meta charset="UTF-8">
<title>대여소 아이디 검색</title>
</head>
<body>
<div align="center">
<h1>아이디 검색</h1>
</div>

<div align="center"><br><br>
   <form action="<c:url value='/search/rentalOffice/ById'/>" 
   name="form" method="post">
   &nbsp;&nbsp;
   <input type="text">&nbsp;&nbsp;
   <input type="submit" value="검색" style="background-color:#ab2948;
   border-radius:30px; color:#FFFFFF;"/>
   <br><br><br>
   <div>검색어 추천 : 10000, 10001, 20002...</div>
   </form>
</div>

</body>
</html>
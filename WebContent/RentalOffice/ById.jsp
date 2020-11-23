<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
   <input type="text" name="rentalOffice_id">&nbsp;&nbsp;
   <input type="submit" value="검색" style="background-color:#ab2948;
   border-radius:30px; color:#FFFFFF;"/>
   <br><br><br>
   <div>검색어 추천 <br><br>
   10000, 10001, 10002<br> 
   20000, 20001<br> 
   30000, 30001<br>
   40000, 40001, 40002<br>
   50000, 50001</div>
   </form>
</div>

</body>
</html>
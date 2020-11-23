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
<title>대여소 이름 검색</title>
</head>
<body>
<div align="center">
<h1>이름 검색</h1>
</div>

<div align="center"><br><br>
   <form accept-charset="UTF-8" action="<c:url value='/search/rentalOffice/ByName'/>" name="form" method="post">
	   &nbsp;&nbsp;
	   <input type="text" name="rentalOffice_name" /> &nbsp;&nbsp;
	   <input type="submit" value="검색" style="background-color:#ab2948; border-radius:30px; color:#FFFFFF;"/>
	   <br><br><br>
	   <div>검색어 추천<br><br>
		   동덕여대 정문<br>
		   동덕여대 후문<br>
		   성북구 보건소<br>
		   북한산국립공원<br>
		   수유역 4번출구<br>
		   강남구청역 1번출구<br>
		   김포공항역 1번출구<br>
		   화곡역 8번출구<br>
		   강동고등학교<br>
		   굽은단리역 2번출구<br>
		   압구정역 3번출구<br>
		   까치산역 2번출구<br>
	    </div>
   </form>
</div>

</body>
</html>
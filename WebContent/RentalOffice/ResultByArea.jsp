<%@ page import="java.util.*, model.*" language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역별 검색 결과</title>
</head>
<body>
<table style="width: 100%">
<caption></caption>
   <tr>
      <th> 이름
      <th> 아이디
      <th> 위도
      <th> 경도
   </tr>
<c:forEach var="RentalOffice" items="${list}">
   <tr>
      <td>${RentalOffice.rental_name}</td> 
      <td>${RentalOffice.rental_id}</td>
      <td>${RentalOffice.latitude}</td>
      <td>${RentalOffice.longitude}</td>
   </tr>
</c:forEach>
</table>
</body>
</html>


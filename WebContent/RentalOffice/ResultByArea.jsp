<%@ page import="java.util.*, model.*" language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>지역별 검색 결과</title>
</head>
<body>
<div style="padding: 50px 0px 0px 0px;">
<table align="center">
   <tr height="50">
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 이름
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 아이디
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 위도
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 경도
   </tr>
<c:forEach var="RentalOffice" items="${list}">
   <tr height="40">
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${RentalOffice.rentalOffice_name}</td> 
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${RentalOffice.rentalOffice_id}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${RentalOffice.latitude}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${RentalOffice.longitude}</td>
   </tr>
</c:forEach>
</table>
</div>
</body>
</html>


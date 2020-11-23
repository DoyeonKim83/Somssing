\<%@ page import="java.util.*, model.*" language="java" contentType="text/html; 
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
<meta charset="EUC-KR">
<title>아이디 검색 결과</title>
</head>
<body>
<div align="center" style="padding: 50px 0px 0px 0px;">
<h3>${result.rentalOffice_id}의 검색 결과입니다</h3><br>
<table align="center">
   <tr height="50">
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 지역
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 이름
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 위도
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 경도
   </tr>
   <tr height="40">
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result.area}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result.rentalOffice_name}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result.latitude}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result.longitude}</td>
   </tr>
</table>
</div>
</body>
</html>


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
#btn {
				width : 100px;
				height : 35px;
				border : 1px solid  #ab2948;
				background-color :  #ab2948;
				color : #FFFFFF;
				border-radius : 30px;
			}
</style>
<meta charset="UTF-8">
<title>아이디 검색 결과</title>
</head>
<body>
<div align="center" style="padding: 50px 0px 0px 0px;">
<h3>${result2.rentalOffice_name}의 검색 결과입니다</h3><br>
<table align="center">
   <tr height="50">
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 지역
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 아이디
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 위도
      <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 경도
	  <th width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE"> 대여하기
   </tr>
   <tr height="40">
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result2.area}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result2.rentalOffice_id}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result2.latitude}</td>
      <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">${result2.longitude}</td>
       <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">
      	<button id="btn" onclick="location.href='<c:url value='/rent' />'">대여</button></td>
   </tr>
</table>
</div>
</body>
</html>


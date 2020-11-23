\<%@ page import="java.util.*, model.*" language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>아이디 검색 결과</title>
</head>
<body>
<table style="width: 100%">
<caption>${result.rentalOffice_id}</caption>
   <tr>
      <th> 지역
      <th> 이름
      <th> 위도
      <th> 경도
   </tr>
   <tr>
      <td>${result.area}</td>
      <td>${result.rentalOffice_name}</td>
      <td>${result.latitude}</td>
      <td>${result.longitude}</td>
   </tr>
</table>
</body>
</html>


<%@ page import="java.util.*, model.*" language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 검색 결과</title>
</head>
<body>
<table style="width: 100%">
<caption>${result2.rentalOffice_name}</caption>
   <tr>
      <th> 지역
      <th> 아이디
      <th> 위도
      <th> 경도
   </tr>
   <tr>
      <td>${result2.area}</td>
      <td>${result2.rentalOffice_id}</td>
      <td>${result2.latitude}</td>
      <td>${result.longitude}</td>
   </tr>
</table>
</body>
</html>


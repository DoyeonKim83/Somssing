<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고장 및 분실 신고 접수 선택</title>
</head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
#Btn {
            width : 250px;
            height : 100px;
            border : 1px solid  #ab2948;
            background-color :  #ab2948;
            color : #FFFFFF;
            border-radius : 30px;
         }
         
</style>
<body>

<div align="center" style="padding: 50px 0px 0px 0px">
<button id="Btn" onclick="location.href='<c:url value='/report/broken'/>'">
고장신고
</button>
<br><br><br>
<button id="Btn" onclick="location.href='<c:url value='/report/lost'/>'">
분실신고
</button>
</div>

</body>
</html>
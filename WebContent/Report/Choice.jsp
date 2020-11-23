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
#searchBtn {
				width : 250px;
				height : 35px;
				border : 1px solid  #ab2948;
				background-color :  #ab2948;
				color : #FFFFFF;
				border-radius : 30px;
			}
</style>
<body>

<div align="center">
<button style="width: 250px; height:100px;" type="button" onclick="self.location = 'Broken.jsp'">
고장신고
</button>
<br>
<button style="width: 250px; height:100px;" type="button" onclick="self.location = 'Lost.jsp'">
분실신고
</button>
</div>

</body>
</html>
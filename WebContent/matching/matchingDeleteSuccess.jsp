<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 완료</title>
<script>
function gomain() {
	f.action = "../MainPage.jsp";
	f.submit();
} 

</script>
</head>
<style>
@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
	#listbtn {
		width : 100px;
		height : 20px;
		border : 1px solid #ab2948;
		background-color :  #ab2948;
		color : #FFFFFF;
		border-radius : 30px;
	}
	
	#gomainbtn {
		width : 100px;
		height : 20px;
		border : 1px solid #ab2948;
		color : #ab2948;
		background-color : #FFFFFF;
		border-radius : 30px;
	}
</style>
<body>
<div align="center">
	<h3>게시물 삭제가 완료되었습니다.</h3>
	<form name="f" method="POST" >
	<input type = "button" value = "게시물 목록" id = "listbtn" onclick="location.href='<c:url value='/matching/list'/>'">
 	<input type = "button" value = "홈으로 이동" id = "gomainbtn" onclick="location.href='<c:url value='/main'/>'">
 	</form>

</div>
</body>
</html>
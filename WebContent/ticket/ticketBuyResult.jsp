<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>이용권 구매 완료</title>
</head>
<script>

</script>
<style>
	@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
	#buy_btn, #gomainbtn {
		width : 300px;
		height : 35px;
		border : 1px solid #ab2948;
		background-color : #ab2948;
		color : #FFFFFF;
		border-radius : 30px;
	}
	
	body {
  		font-family: 'Nanum Barun Gothic', sans-serif;
	}
	
	table {
    	border-collapse: collapse;
    }
    
    #ticket_result_guide {
    
    	font-size:12px;
    	text-align : center;
    	
    	width : 300px;
    	height : 40px;
    	background-color :  #ffdbe4;
    	
    }

</style>
<body>
<div align="center">
	<h2>이용권 구매가 완료되었습니다.</h2>
	<br>
		
	<table>	<tr> <td id = "ticket_result_guide">
	회원님의 앞으로 이용가능한 시간: <br><text style="font-size:20px; color:red;" >${user.remain_time}</text>
	</td> </tr> </table>
	<br><br>
	<input type = "button" value = "홈으로 이동" id = "gomainbtn" onClick="location.href='<c:url value='/main' />'">	
	
</div>

</body>
</html>
<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>자전거 산책로 검색</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/recommendation.css' />" type="text/css">
<style>
#whiteButton {
		width : 50px;
		height : 35px;
		border : 1px solid  #ab2948;
		color :  #ab2948;
		background-color : #FFFFFF;
		border-radius : 30px;

}
</style>
<script>
	function levelalert(){
	    alert("알맞은 난이도를 입력하세요.");
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br><br>
<div data-obj-id="Y7GTN" data-obj-type="icon"><svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" data-svg-content="true" fill="#000000"><path d="M28 7.6c1.98 0 3.6-1.61 3.6-3.6S29.98.4 28 .4c-1.99 0-3.6 1.61-3.6 3.6s1.61 3.6 3.6 3.6zm.24 12.4H38v-3.6h-7.25l-4-6.66c-.59-1-1.68-1.66-2.92-1.66-.34 0-.67.05-.98.14L12 11.6V22h3.6v-7.33l4.21-1.31L12 44h3.6l5.74-16.22L26 34v10h3.6V31.19l-4.98-9.08 1.47-5.74L28.24 20z"></path></svg></div>
<div data-text-content="true" style="font-size:16px; font-weight: bold;">자전거 산책로 검색</div><br>
<% if (request.getAttribute("exception") != null) %> <script> levelalert(); </script> <%; %>
<form name="form" method="POST" action="<c:url value='/recommendation/result' />">
        <table>
	  	  <tr height="40">
			<td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">난이도로 검색</td>
			<td width="250" bgcolor="#ab2948" style="padding-left: 10">
				<input type="text" style="width:240px;" name="level">
			</td>
			<td width="50" bgcolor="#ab2948" style="padding-left: 10">
				<input type="submit" value="검색" id="whiteButton">
			</td>
		  </tr>
	    </table>
	    <br><br>
	         난이도에 따른 검색이 가능합니다. <br>
	         제공 난이도 : 매우 쉬움, 쉬움, 보통, 어려움, 매우 어려움  <br>
</form>
</body>
</html>
<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>개인정보 상세 확인</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel=stylesheet href="<c:url value='/css/profile.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<div align="center">
<br><br>
<div data-obj-id="qszjS" data-obj-type="icon">
	<svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" data-svg-content="true" fill="#000000"><path d="M8 12H4v28c0 2.21 1.79 4 4 4h28v-4H8V12zm32-8H16c-2.21 0-4 1.79-4 4v24c0 2.21 1.79 4 4 4h24c2.21 0 4-1.79 4-4V8c0-2.21-1.79-4-4-4zm-2 18H18v-4h20v4zm-8 8H18v-4h12v4zm8-16H18v-4h20v4z"></path></svg></div>
  <div data-text-content="true" style="font-size:16px; font-weight: bold;">프로필 상세 보기</div>
  <br>
  	<table>
	  	  <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">아이디</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.user_id}
			</td>
		  </tr>
		  <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">이름</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.userName}
			</td>
		  </tr>		  
		  <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">이메일</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.email}
			</td>
		  </tr>		  
		   <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">핸드폰 번호</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.phone}
			</td>
		  </tr>
		   <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">지역</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.addr}
			</td>
		  </tr>
		   <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">생년월일</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.birth}
			</td>
		  </tr>	
		   <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">성별</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.gender}
			</td>
		  </tr>	
	 	</table>
	    <br>
	    <input type="button" value="수정" id="redButton" onclick="location.href='<c:url value='/user/update_action' />'"> &nbsp;
	    <input type="button" value="탈퇴" id="whiteButton" onclick="location.href='<c:url value='/user/view?command=delete' />'"> &nbsp;	
	    <br><br>
  		<input type="button" value="프로필 메인으로 이동" id="redButton" onclick="location.href='<c:url value='/user/view?command=main' />'"> &nbsp;	
	    <!-- 파라미터 -->
 	    <br><br>	
</div>    
</body>
</html>
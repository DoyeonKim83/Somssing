<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>프로필 메인 페이지</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel=stylesheet href="<c:url value='/css/profile.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<div align="center">
<br><br>
<div data-obj-id="g2Tac" data-obj-type="icon">
	<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="42" height="43.762001037597656" viewBox="0 0 32 33.762001037597656" fill="#000000" data-svg-content="true"><g><path d="M 22,6c0-3.212-2.788-6-6-6S 10,2.788, 10,6c0,3.212, 2.788,6, 6,6S 22,9.212, 22,6zM 16,14c-5.256,0-10,5.67-10,12.716s 20,7.046, 20,0S 21.256,14, 16,14z"></path></g>
	</svg></div>
  <div data-text-content="true" style="font-size:16px; font-weight: bold;">profile</div>
  <br>
  	  	<table>
	  	  <tr>
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.userName}
			</td>
		  </tr>
		  <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">지역</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.addr}
			</td>
		  </tr>		  
		  <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">생년월일</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.birth}
			</td>
		  </tr>		  
		   <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">성별</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.gender}
			</td>
		  </tr>
		   <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">현재 등급</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.grade}
			</td>
		  </tr>
		   <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">현재 대여 횟수</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.rent_time}
			</td>
		  </tr>	
		  <tr>
			<td width="100" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">다음 등급까지 남은 대여 횟수</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
				${user.nextlevel_time}
			</td>
		  </tr>	
	 	</table>   
  <br>
	<input type="button" value="개인 정보 상세 보기" id="redButton" onclick="location.href='<c:url value='/user/detail/view' />'"> &nbsp;
	<input type="button" value="등급 안내" id="whiteButton" onclick="location.href='<c:url value='/user/grade' />'"> &nbsp;
 	<br><br>	
 	</div>
</body>
</html>
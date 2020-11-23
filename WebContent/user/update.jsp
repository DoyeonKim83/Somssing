<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>개인 정보 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/profile.css' />" type="text/css">
<script>
function userList(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<div align="center">
<br><br>
<div data-obj-id="mU8bN" data-obj-type="icon"><svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" data-svg-content="true" fill="#000000"><path d="M6 34.5V42h7.5l22.13-22.13-7.5-7.5L6 34.5zm35.41-20.41c.78-.78.78-2.05 0-2.83l-4.67-4.67c-.78-.78-2.05-.78-2.83 0l-3.66 3.66 7.5 7.5 3.66-3.66z"></path></svg></div>
<div data-text-content="true" style="font-size:16px; font-weight: bold;">개인 정보 수정</div>
<br>
<!-- Update Form  -->
<form name="form" method="POST" action="<c:url value='/user/update_action' />">
  <table>
	  	  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">사용자 ID</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				${user.user_id}
			</td>
		  </tr>
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">비밀번호</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				<input type="password" style="width: 250" name="password">
			</td>
		  </tr>
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">비밀번호 확인</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				<input type="password" style="width: 250" name="password2">
			</td>
		  </tr>
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">이름</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				<input type="text" style="width: 250" name="username">
			</td>
		  </tr>
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">이메일 주소</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
				<input type="email" style="width: 250" name="email">
			</td>
		  </tr>	
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">전화번호</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
		 		<input type="text" style="width: 250" name="phone">
			</td>
		  </tr>		
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">지역</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
		 		<input type="text" style="width: 250" name="addr">
			</td>
		  </tr>	
		  <tr height="35">
			<td width="150" bgcolor="f0b3c1" align="center" height="35" style="padding-left: 10; padding-right : 10;">생년월일</td>
			<td width="250" style="padding-left: 10; padding-right : 10;">
		 		<input type="date" style="width: 250" name="birth">
			</td>
		  </tr>	
	    </table>
	    <br>
  <input type="submit" value="수정" id="redButton"> &nbsp;
  <input type="button" value="취소" id="whiteButton" onClick="userList('<c:url value='/user/detail/view' />')"> &nbsp;
</form>
</div>
</body>
</html>
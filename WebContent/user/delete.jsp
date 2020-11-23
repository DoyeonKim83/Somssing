<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 탈퇴</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/profile.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br><br>
<div data-obj-id="XlYB3" data-obj-type="icon"><svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" data-svg-content="true" fill="#000000"><path d="M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z"></path></svg></div>
<div data-text-content="true" style="font-size:16px; font-weight: bold;">회원 탈퇴</div>
<br>
<!-- Update Form  -->
<form name="form" method="POST" action="<c:url value='/user/delete' />">
  <table>
	  	  <tr height="40">
			<td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">탈퇴 사유 입력</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				<input type="text" style="width:240px; height:240px;" name="reason">
			</td>
		  </tr>
		    
	    </table>
	    <br>	  
	    <input type="submit" value="탈퇴" id="redButton"> &nbsp;
		<input type="button" value="취소" id="whiteButton" onClick="userList('<c:url value='/user/detail/view' />')"> &nbsp;
</form>
</body>
</html>
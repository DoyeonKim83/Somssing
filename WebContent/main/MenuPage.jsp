<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>MenuPage</title>

<style>

@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}

#logoutBtn {
				width : 250px;
				height : 35px;
				border : 1px solid  #ab2948;
				background-color :  #ab2948;
				color : #FFFFFF;
				border-radius : 30px;
			}
			
 .menu { 
 text-align:center;
 background-color:white;  
 border: 3px solid #ab2948; 
 padding-bottom: 50px;
 padding-right:150px;
 padding-left:150px;
 padding-top:50px;
 height:100px;
 }

 .aboutme { 
 background-color:#ffdbe4; 
 border-radius: 2em; }
 
</style>



</head>
<body>
<div style="padding:20px 30px 10px 30px">
	<div align="left">
			<a href="<c:url value='/main' />"><img src="<c:url value='/images/back.png' />" width="35" height="30"></a>
		</div>
		
	
	<div align="center">
		<table align="center" border="0" width="70%" height="500" style="table-layout: fixed; border-spacing:20px;">
			<tr>
			    <td><a href="<c:url value='/user/view?command=main' />"><div class="menu">마이페이지 </div></a></td>
			    <td><a href="<c:url value='/rent/list' />"><div class="menu">대여정보</div></a></td>
			</tr>
			<tr>
			    <td><a href="<c:url value='/ticket/buyForm' />"><div class="menu">이용권결제</div></a></td>
			    <td><a href="<c:url value='/matching/list' />"><div class="menu">매칭게시판</div></a></td>
			</tr>
			<tr>
			    <td><a href="<c:url value='/recommendation' />"><div class="menu">추천코스</div></a></td>
			    <td><a href="<c:url value='/report/choice '/>"><div class="menu">고장/분실 신고</div></a></td>
			</tr>
		 </table>
	 </div>
	 
	 <div align="center">
		<button id="logoutBtn" onclick="location.href='<c:url value='/user/logout' />'">로그아웃</button>
	</div>
	 
 </div>


</body>
</html>
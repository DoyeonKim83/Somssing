<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>messageSent</title>
	<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
		table,th,td{
			border: 1px solid gray;
         border-collapse: collapse;
			table-layout:fixed;
			margin-left : auto;
			margin-right : auto;			
		}
		td {
			height:25px;
         	text-align : center;
		}
		th {
			background-color : #ffdbe4;
         	height : 30px;
         	text-style:bold;
		}
		table{
			width: 90%
		}
		body{
			font-family: 'Nanum Barun Gothic', sans-serif;
			}
		#send{
			border-radius : 30px;
			background-color : #f0b3c1;
			color : #FFFFFF;
			float : right;
		}
		#receive{
			border-radius : 30px;
			background-color : #f0b3c1;
			color : #FFFFFF;
			float : right;
		}
		
		#rbtn {
         width : 100px;
       	 height : 20px;
         border-radius : 3px; 
         border : 1px solid #ab2948; 
         background-color : #FFFFFF;
         color : #ab2948;
         
                  
      }
	</style>
</head>
<body>
<div style="padding:20px 80px 10px 80px" align="left">
      <a href="<c:url value='/menu' />"><img src="<c:url value='/images/menuicon.png' />" width="35" height="30" /></a>
   </div>
<div align="center">
	<h2>보낸 메시지함</h2>
	
	<form action="<c:url value='/message/messageSent' />" 
   name="messageSend" method="POST">
   <input type="button" id="rbtn" value="매칭 게시판" onClick="location.href='<c:url value='/matching/list' />'">
	<input type="button" id="rbtn" value="받은쪽지함" onClick="location.href='<c:url value='/message/messageReceive' />'">
	<br><br>
	<table>
		<thead>
			<tr>
				<th style="width:200px;" id="board_th">내용</th>
				<th style="width:150px;" id="board_th">보낸날짜</th>
				<th style="width:150px;" id="board_th">받은사람</th>
			</tr>
			<tr>
				<c:forEach var="post" items="${list}">
				<tr>
		         	<td > ${post.msg_content } </td>
		         	<td> ${post.send_time } </td>
		         	<td> ${post.receiver_id } </td>
	        	</tr>
	         </c:forEach>
			</tr>
		</thead>
	</table>
	</form>
</div>
	
</body>
</html>
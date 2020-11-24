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
			border: 1px solid black;
			border-collapse: collapse;
			table-layout:fixed;
			margin-left : auto;
			margin-right : auto;			
		}
		table{
			width: 100%
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
		h3{
			text-align : center;
		}
	</style>
</head>
<body>
	<h3>���� �޽�����</h3>
	<form action="<c:url value='/message/messageSent' />" 
   name="messageSend" method="POST">
	<table>
		<thead>
			<tr>
				<th>����</th>
				<th>�����ð�</th>
				<th>�������</th>
			</tr>
			<tr>
				<c:forEach var="post" items="${list}">
				<tr>
		         	<td> ${post.msg_content } </td>
		         	<td> ${post.send_time } </td>
		         	<td> ${post.receiver_id } </td>
	        	</tr>
	         </c:forEach>
			</tr>
		</thead>
	</table>
	</form>
	<hr>
	<!-- <p align="center">���� ������ �����ϴ�.</p> -->

	<input type="button" id="send" value="��Ī �Խ��� �̵�" onClick="location.href='<c:url value='/matching/list' />'">
	<input type="button" id="receive" value="�����������" onClick="location.href='<c:url value='/message/messageReceive' />'">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <title>matching board</title>
   <script>
   function writePost() {
		f.action = "matchingWriting.jsp";
		f.submit();
	}
   </script>
   <style>
      table,th,td{
         border: 1px solid gray;
         border-collapse: collapse;
         
      }
      table{
         width: 90%
      }
      body{
         font-family: 'Nanum Barun Gothic', sans-serif;
         }
      
      #writeBtn {
      	 width : 150px;
		 height : 30px;
         border-radius : 30px; 
         border : 1px solid #ab2948; 
         background-color : #FFFFFF;
         color : #ab2948;
         float: right;
         margin-right:200px;         
      }
      
      
   </style>
</head>
<body>
<div align = "center">
	<br><br>
	
	<form name="f" method="POST" action="<c:url value='/matching/checkPost'/>">   
	<h3>매칭 게시판</h3> 	
   <input type="button" value="게시글 작성" id="writeBtn" onClick="location.href='<c:url value='/matching/write' />'"> <br><br>
	
	<table align="center">
    	<tr>
        	<th style="width:150px;">번호</th>
            <th>제목</th>
            <th style="width:200px;">작성자</th>
            <th style="width:200px;">날짜</th>
         </tr>
         <tr>
         <c:forEach var="post" items="${comList}">
         <tr>
         	<td style="width:150px;"> ${post.comm_id} </td>
         	<td> ${post.title } </td>
         	<td style="width:200px;"> ${post.user_id } </td>
         	<td style="width:200px;"> ${post.comm_time } </td>
         </tr>
         </c:forEach>
   </table>
	<input type="hidden" name="user_id" value="${user_id}">
</form>
</div>
</body>
</html>
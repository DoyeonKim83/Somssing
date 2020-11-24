<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      #matchingboard,#matchingboard_th, #matchingboard_td{
         border: 1px solid gray;
         border-collapse: collapse;
         
      }
      #matchingboard_td {
         height:25px;
         text-align : center;
      }
       #matchingboard_th {
         background-color : #ffdbe4;
         height : 30px;
         text-style:bold;
      }
      #matchingboard {
         width: 90%
      }
      body{
         font-family: 'Nanum Barun Gothic', sans-serif;
         }
      
      #rbtn {
         width : 100px;
       	 height : 20px;
         border-radius : 3px; 
         border : 1px solid #ab2948; 
         background-color : #FFFFFF;
         color : #ab2948;
         
                  
      }
      #gomainBtn {
         width : 300px;
       	 height : 30px;
         border-radius : 30px; 
         border : 1px solid #ab2948; 
         background-color : #ab2948;
         color : #FFFFFF;
      }
      
      #post_title {
         border : 0px;
         background-color : white;
         color:black;
         font-size : 14px;
         
      }
      #matching_guide {
    	
    	padding-left: 10; padding-right : 10;
    	 padding-bottom : 10;
    	font-size:12px;
    	text-align : center;
    	line-height:13px;
    	height : 50px;
    	width: 60%
    	 
    }
      
      
   </style>
</head>
<body>
<div align = "center">
   <br><br>
   <div style="padding:20px 80px 10px 80px" align="left">
      <a href="<c:url value='/menu' />"><img src="<c:url value='/images/menuicon.png' />" width="35" height="30" /></a>
   </div>
   <form name="f" method="GET" action="<c:url value='/matching/checkPost'/>">   
   <h2>매칭 게시판</h2>  
   <input type="button" value = "받은 쪽지함" id="rbtn" onClick="location.href='<c:url value='/message/messageReceive' />'">
   <input type="button" value = "게시글 작성" id="rbtn" onClick="location.href='<c:url value='/matching/writeForm' />'"> 
   <br>
   <table>	<tr> <td id = "matching_guide">
	-솜씽이들을 만날 수 있는 매칭 보드입니다. 	<br>
	-욕설 및 비방글은 <text style="color:#d1150f;" >무통보 삭제 </text>합니다.	<br>
	</td> </tr> </table>
 
   <table align="center" id="matchingboard">
       <tr id="matchingboard_tr">
           <th style="width:150px;" id="matchingboard_th">번호</th>
            <th id="matchingboard_th">제목</th>
            <th style="width:200px;" id="matchingboard_th">작성자</th>
            <th style="width:200px;" id="matchingboard_th">날짜</th>
         </tr>
         <tr>
         <c:forEach var="post" items="${comList}">
         <tr>
            <td style="width:150px;" id="matchingboard_td"> ${post.comm_id} </td>        
            <td style="width:300px;" id="matchingboard_td"> <a href="checkPost?user_id=${post.user_id}&comm_id=${post.comm_id}"> ${post.title } </a></td>
            <td style="width:200px;" id="matchingboard_td"> ${post.user_id } </td>
            <td style="width:200px;" id="matchingboard_td"> ${post.comm_time } </td>
         </tr>
         </c:forEach>
   </table>
    <br> <input type="button" value = "메인페이지" id="gomainBtn" onClick="location.href='<c:url value='/main' />'">
</form>
</div>
</body>
</html>
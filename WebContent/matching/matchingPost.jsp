<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 확인</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
</head>
<script>

</script>
<style>
@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
#communi_btn {
      margin-left : 50px;
      
      border : 1px solid #ffdbe4;
      background-color : #ffdbe4;
      color : grey;
      border-radius : 4px;
      font-size: 8px;
   }
   
   #update_btn , #delete_btn{
      width : 100px;
      height : 25px;
      border : 1px solid #ab2948;
      background-color : #FFFFFF;
      color : #ab2948;
      border-radius : 30px;
      font-size : 12px;
   }
   #golist_btn {
      width : 200px;
      height : 30px;
      border : 1px solid #ab2948;
      background-color : #ab2948;
      color : #FFFFFF;
      border-radius : 30px;
   }
   td {
      width : 500px;
   
   }
</style>

<body>
<div align="center">

<form name="f" method="GET" accept-charset="UTF-8" action="<c:url value='/matching/updateForm' />" > 
   
   
      <table> <tr> <td class="form-control"  style = "border:0">
       <p style = "font-size:10pt;"> ${com.comm_id}</p> 
       <input type="hidden" name="comm_id" value= "${com.comm_id}">
   
   </td></tr> 
   
   <tr> <td class="form-control" style = "height:50px; padding-top:10px;">
       <text style = "font-size:14pt;"> ${com.title} </text>
       <input type="hidden" name="title" value= "${com.title}">
    
    </td></tr>  
    <tr> <td style = "height:20px;" > </td> </tr>
    
    <tr> <td class="form-control" style = "height:100px; padding-top:10px;">
    
          ${com.content }
         <input type="hidden" name="content" value= "${com.content}">
         
    
    </td></tr> 
    
    <tr> <td class="form-control" style = "height:50px; border:0">
       ${com.user_id} <input type = "button" value = "쪽지 보내기"  id = "communi_btn" onClick="location.href='<c:url value='/message/messageSend'/>'"> 
       <input type="hidden" name="user_id" value= "${com.user_id}">
       <text style="float:right;"> ${com.comm_time } </text>
       <input type="hidden" name="comm_time" value= "${com.comm_time}">
    
    </td></tr>
    </table>
    
    
    <c:if test="${user_id eq com.user_id }">
    <input type = "submit" value = "게시글 수정" id = "update_btn" style = "margin-left:30px;" >
    <input type = "button" value = "게시글 삭제" id = "delete_btn" style = "margin-left:5px;" 
       onClick="location.href='<c:url value='/matching/delete'>
          <c:param name='comm_id' value='${com.comm_id}'/>
          </c:url>'">
    <br><br>
    </c:if>
    <input type = "button" value = "게시글 목록" id = "golist_btn" style = "margin-left:30px;" onClick="location.href='<c:url value='/matching/list' />'">
   
</form>
</div>
</body>
</html>
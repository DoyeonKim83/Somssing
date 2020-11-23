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
	
	#update_btn {
		width : 150px;
		height : 30px;
		border : 1px solid #ab2948;
		background-color : #FFFFFF;
		color : #ab2948;
		border-radius : 30px;
	}
	#golist_btn {
		width : 150px;
		height : 30px;
		border : 1px solid #ab2948;
		background-color : #ab2948;
		color : #FFFFFF;
		border-radius : 30px;
	}
</style>

<body>

<form name="f" method="POST" accept-charset="UTF-8" > 
	
	<div class="form-group" style = "font-size:12pt; padding-left:30px;">
	
		<label for="title" align="center">제목</label>
    	<p style = "font-size:12pt;"> hi hello 제목이야! </p> 
    	<p style = "font-size:12pt;"> ${com.title}</p> 
    	<input type="hidden" name="title" value= "${com.title}">
    </div>
    
    <div class="form-group" style = "font-size:12pt; padding-left:30px;">
	
		<label for="user" align="center">작성자
			<input type = "button" value = "쪽지 보내기"  id = "communi_btn" onClick="location.href='<c:url value='/message/send'/>'"> 
		</label>
    	<p style = "font-size:12pt;"> ${com.user_id} 성지운</p> 
    	<input type="hidden" name="user_id" value= "${com.user_id}">
    </div>
    
    <div class="form-group" style = "font-size:12pt; padding-left:30px;">
	
		<label for="day" align="center">게시물 날짜 </label>
    	<p style = "font-size:12pt;"> ${com.comm_time }</p> 
    	<input type="hidden" name="comm_time" value= "${com.comm_time}">
    </div>
    
    <div class="form-group" style = "font-size:12pt; padding-left:30px;">
    	<label for="content">내용</label>
   		<p style = "font-size:10pt;"> ${com.content } </p>
   		<input type="hidden" name="content" value= "${com.content}">
   		
 	</div>
 	<input type = "button" value = "게시글 수정" id = "update_btn" style = "margin-left:30px;" onClick="location.href='<c:url value='/matching/updateForm' />'">
 	<input type = "button" value = "게시글 목록" id = "golist_btn" style = "margin-left:30px;" onClick="location.href='<c:url value='/matching/list' />'">
	
</form>

</body>
</html>
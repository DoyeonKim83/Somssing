<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
<script>
	$(document).ready(function(){
		$('#content').on('keyup', function(){
			if($(this).val().length > 100) {
				$(this).val($(this).val().substring(0, 100));
			}
		})
	})
	
	$(document).ready(function(){
		$('#title').on('keyup', function(){
			if($(this).val().length > 20) {
				$(this).val($(this).val().substring(0, 20));
			}
		})
	})

</script>
</head>

<style>
@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
#write_btn {
		width : 200px;
		height : 35px;
		border : 1px solid #ab2948;
		background-color : #ab2948;
		color : #FFFFFF;
		border-radius : 3px;
	}
	#title, #content {
		
		width : 500px;
	
	}
	
	#cancel_btn {
		width : 50px;
		height : 35px;
		border : 1px solid #ab2948;
		background-color : #FFFFFF;
		color : #ab2948;
		border-radius : 3px;
	}
	
</style>
<body>
<form name="f" method="GET" accept-charset="UTF-8" action="<c:url value='/matching/updatePost'/>"> 
	<div align="center">
	<h3 >게시글 수정</h3>
	<div class="form-group">
	<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
	<!-- required 속성을 설정하면 필수입력 사항이된다. -->
	<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
    	<input type="text" class="form-control" id="title" placeholder="제목 입력(최대  20글자)" name="title" value = "${com.title}"
    	 maxlength="100" required="required" pattern=".{4,20}">
    </div>
    
    <div class="form-group">
<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
   <textarea class="form-control" rows="5" id="content"   name="content" placeholder="내용 작성(최대  100글자)" required="required" pattern=".{1,100}">${com.content}</textarea>
	 </div>
 	<input type="button" id="cancel_btn" value="취소" onclick="history.back()">
	<input type = "submit" value = "수정" id = "write_btn">
	<input type="hidden" name="comm_id" value= "${com.comm_id}">

</form>
	</div>
</body>
</html>
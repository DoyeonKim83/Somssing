<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>회원가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
function userCreate() {
	if ( f.userId.value == "" ) {
		alert("사용자 아이디를 입력하십시요.");
		f.userId.focus();
		return false;
	} 
	if ( f.password.value == "" ) {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return false;
	}
	if ( f.name.value == "" ) {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return false;
	}
	if (f.password.value != f.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(f.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		f.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(f.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		f.phone.focus();
		return false;
	}
	f.submit();
}

</script>
<style>
	@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
	#readuserbtn, #createuserbtn {
		width : 150;
		height : 35;
		border : 1px solid #ab2948;
		background-color :  #ab2948;
		color : #FFFFFF;
		border-radius : 30px;
	}
	
	#gomainbtn {
		width : 150;
		height : 35;
		border : 1px solid #ab2948;
		color : #ab2948;
		background-color : #FFFFFF;
		border-radius : 30px;
	}
	
	body {
  		font-family: 'Nanum Barun Gothic', sans-serif;
	}
	
	table, tr {
		border : 1px solid #ab2948;
	}
	table {
    	border-collapse: collapse;
    }
    
    tr {
    	height : 35;
    }
</style>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div align = "center">
<br>
<!-- write Form  -->
	<form name="f" method="POST" action="<c:url value='/user/register'/>">
	        <!--contents-->
		<h3>회원가입</h3> 
			  
		  <table>
		  	  <tr >
				<td width="100" align="center">사용자ID</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="width: 250;" name="user_id">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">비밀번호</td>
				<td  bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="password" style="width: 250" name="password">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">비밀번호<br>확인</td>
				<td  bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="password" style="width: 250" name="password2">
				</td>
			  </tr>
		  	  <tr>
				<td width="100" align="center">이름</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="width: 250" name="userName" >
				</td>
			  </tr>
			  <tr>
				<td width="100" align="center">생년월일</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<!-- <input type="text" style="width: 62" name="year"> 년
					<input type="text" style="width: 62" name="month"> 월
					<input type="text" style="width: 62" name="day"> 일 -->
					<input type="date" style="width: 250" name="birth">
				</td>
			  </tr>	
			  <tr>
				<td width="100" align="center">성별</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">				
					<input type="radio" name="gender" value="woman" checked="checked">여자
					<input type="radio" name="gender" value="man" >남자
				</td>
			  </tr>	
			  <tr>
				<td width="100" align="center">이메일 주소</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="email" style="width: 250" name="email"		>
				</td>
			  </tr>	
		  	  <tr>
				<td width="100" align="center">전화번호</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="width: 250" name="phone" placeholder = "010-1111-2222"  >
				</td>
			  </tr>	
			  <tr>
				<td width="100" align="center">지역</td>
				<td bgcolor="ffffff" style="padding-left: 10; padding-right : 10;">
					<input type="text" style="width: 250" name="addr" placeholder = "예시)서울시 성북구" >	</td>
			  </tr>	
			 
			  </table>
			  <br>
	 		<input type = "button" value = "회원가입" id = "createuserbtn" onClick = "userCreate()">	
	 		<input type = "button" value = "홈으로 이동" id = "gomainbtn" onClick="location.href='<c:url value='/main'/>'">	
	 		
		  
		    
	</form>
</div>
</body>
</html>
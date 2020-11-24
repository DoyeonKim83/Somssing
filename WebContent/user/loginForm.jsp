<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
		<head>
		<title>로그인</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script>
		function userCreate() {
			f.action = "registerForm.jsp";
			//f.action="<c:url value='/user/registerForm' />";
			f.submit();
		}
		
		function login() {
			if ( f.user_id.value == "" ) {
				alert("사용자 아이디를 입력하십시요.");
				f.user_id.focus();
				return false;
			} 
			if ( f.password.value == "" ) {
				alert("비밀번호를 입력하십시요.");
				f.password.focus();
				return false;
			}	
			f.submit();
		}
		</script>
		<style>
			@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
			body {
				  font-family: 'Nanum Barun Gothic', sans-serif;
			}
			#loginbtn {
				width : 250;
				height : 35;
				border : 1px solid  #ab2948;
				background-color :  #ab2948;
				color : #FFFFFF;
				border-radius : 30px;
			}
			
			#createuserbtn {
				width : 250;
				height : 35;
				border : 1px solid  #ab2948;
				color :  #ab2948;
				background-color : #FFFFFF;
				border-radius : 30px;
			}
			
			
			
			#loginId, #loginpw {
				border : 1px solid #aea8a9;
				border-radius : 3px;
				width: 250; 
				height : 35;
			}
		</style>
		</head> 
		<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
		 <div align = "center">
		 <form name="f" accept-charset="UTF-8" method="GET" action="<c:url value='/user/login' />" >	 
		   <h3><br>로그인</h3>
			 <table>
				 <tr> <td > <input type = "text" placeholder = " 아이디" name = "user_id" id = "loginId"> </td> </tr>
				 <tr> <td style="height : 2; "></td> </tr>
				 <tr> <td > <input type = "text" placeholder = " 비밀번호" name = "password" id = "loginpw"> </td> </tr>
				 <tr> <td style="height : 12; "></td> </tr>
				 <tr> <td align = "center"> <input type = "submit" value = "로그인" id = "loginbtn"> </td> </tr>
				 <tr> <td style="height : 2; "></td> </tr> <!-- onClick="location.href='<c:url value='/user/registerForm' />'"> -->
				 <tr> <td align = "center"> <input type = "button" value = "회원가입" id = "createuserbtn" onClick="location.href='<c:url value='/user/registerForm' />'"> </td> </tr>
		
			 </table>
		 </div> 
		 </form>
		</body>
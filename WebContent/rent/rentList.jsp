<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>�뿩����</title>

<style>
  @import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
  @charset "utf-8";
* {
  margin:0;
  padding:0;
}

a:link {
  color: #ffdbe4;
  text-decoration: underline; 
}
a:visited {
  color: #ffdbe4;
  text-decoration: underline;
}
a:hover, a:active, a:focus {
  text-decoration: none;
}
.container {
  margin:0 auto;
  width: 960px;
  background-color:#fff;
  border:1px solid #E7E7E7
}
header {
  position:relative;
  height: 180px;
  margin-top:0;
  padding-top:120px;
  padding-right:15px;
  background-position: left top;
}

.navi{
  position:relative;
  background:#ab2948;
  margin-top:-15px;
  width:960px;
  height:60px;
}

.navi ul{
  list-style: none; 
  height:40px;
  padding-top:10px;
  padding-bottom:5px;
}
.navi ul li {
  display:inline;
  float:left;
  font-size:15px;
}
.navi a, .navi a:visited {
  padding: 10px 5px 5px 35px;
  display: block;
  color:#fff;
  width: 150px; 
  text-decoration: none;
}
.navi a:hover, .navi a:active, .navi a:focus {
    text-shadow:0px 2px 2px #000;
    color:#ffdbe4;
}

.content {
  background-color: #FFFFFF;  
  padding-top:5px;
  padding-left:10px;
  width: 720px;
  float: left;
}

header{
  display: block;
}
body{
	font-family: 'Nanum Barun Gothic', sans-serif;
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
</style>
</head>

<body>
<div class="container">
  <header>
      <h1>�뿩����</h1>
  </header>  
    <nav class="navi">
      <ul>
        <li><a href="rentList.jsp">�뿩��û/���</a></li>
        <li><a href="return.jsp">�ݳ�</a></li>
        <li><a href="rent.jsp">�뿩</a></li>
        <li><a href="history.jsp">�뿩/�ݳ��̷�</a></li>
      </ul>
    </nav>  
    <h2>�뿩��û���</h2>
	<!-- <a>�뿩��û ����� �����ϴ�.</a> -->
	<table>
		<thead>
			<tr>
				<th>�����ð�</th>
				<th>�ݳ��ð�</th>
				<th>������ ��ȣ</th>
			</tr>
			<tr>
				<c:forEach var="post" items="${list}">
				<tr>
		         	<td> ${post.rental_time} </td>
		         	<td> ${post.return_time } </td>
		         	<td> ${post.bike_id } </td>
	        	</tr>
	        	</c:forEach>
			</tr>
		</thead>
	</table>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여소 검색</title>
</head>
<body>

<div align="center">
<h2>대여소 검색하기</h2>
</div>

<br><br>
<div align="center" >
<div style="border: 1px solid red;">
<button style="width: 250px; height:100px;" type="button"  onclick="self.location = 'ByArea.jsp'">
지역별 모아보기
</div><br><br>
<div style="border: 1px solid blue;">
<button style="width: 250px; height:100px;" type="button" value="대여소 아이디로 검색" onclick="self.location = 'ById.jsp'">
대여소 아이디로 검색
</div>
<div style="border:1px solid red;">
<button style="width: 250px; height:100px;" type="button" onclick="self.location = 'ByName.jsp'">
대여소 이름으로 검색
</div><br><br>


</div>


<div align="right" style="height:7%">
   <form action="RentalOfficeSearch.jsp" name="search" action="" method="post">
   대여소 검색&nbsp;&nbsp;
   <input type="text" >&nbsp;&nbsp;
   <input type="submit" value="검색" style="background-color :  #ab2948;border-radius : 30px; color : #FFFFFF;"/>
   </form>
</div>


</body>
</html>
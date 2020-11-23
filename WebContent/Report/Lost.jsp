<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
</style>
<meta charset="UTF-8">
<title>분실 신고</title>
</head>

<body>

<div style="padding:20px 50px 20px 50px;" align="center"> 
   <h2>* 분실 신고 *</h2>
   <h5>&nbsp;&nbsp;빠른 상담은 1544-8282</h5>
   <div style="padding:5px 20px 0px 20px" align="center">
      <h4>* 분실 신고 *</h4>
      <div style="padding:0px 10px 0px 10px; height:170px;">
         <form action="<c:url value='/report/choice/lost' />">
            &nbsp;&nbsp;&nbsp;자전거 일련번호 <input type="text" name="bike_id" style="border:1px solid #ab2948;">
            &nbsp;&nbsp;&nbsp;대여소 장소 <input type="text" name="rentalOffice_name" style="border:1px solid #ab2948;"><br><br>
            &nbsp;&nbsp;&nbsp;대여소 아이디<input type="text" name="rentalOffice_id" style="border:1px solid #ab2948;"><br><br>
            &nbsp;&nbsp;&nbsp;사유<input type="text" name="why_BrokenOrLost" style="width:60%; height:70px; border:1px solid #ab2948;"><br><br>
            <input type="submit" value="접수하기"><br><br>
         </form>
      </div>
   </div>
</div>
</body>
</html>
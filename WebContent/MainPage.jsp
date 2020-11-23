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
<title>솜씽이, 솜솜아 같이 탈래?</title>
</head>
<body>
<body>
<div style="padding:20px 30px 10px 30px">

	<div align="left">
		<a href="MenuPage.jsp"><img src="menuicon.png" width="35" height="30"></a>
	</div>

	<div align="center">
		<h1>솜씽이, 솜솜아 같이 탈래?</h1>
	</div>

	<div style="padding:40px 150px 40px 150px; height:500px;">
		<div style="border: 1px solid white;" align="center">
			<div align="center" style="background-color: #f0b3c1; border-radius: 2em;">
				<h4>My Bike</h4><br>
					${user.userName } 님 환영합니다!
					내사진동그라미 형태로 뻔한 프로필<br>
					이용권 시간 : ${user.remain_time} 시간<br><br>
					사용중인 자전거 : 일련번호 1031 <br>
					남은시간 : 결제시간+이용시간-현재시간*** <br>
			</div>
		</div>
		<br><br>
		<div style="width:100%; height:80%; border: 1px solid white;">
			<div align="right" style="height:7%">
					<form action="RentalOfficeSearch.jsp" name="search" action="" method="post">
					대여소 검색&nbsp;&nbsp;<input type="text" >&nbsp;&nbsp;<input type="submit" value="검색" style="background-color :  #ab2948;border-radius : 30px; color : #FFFFFF;
					"/>
				</form>
			</div>
			
			<div align="left" style="padding:0px 10px 0px 10px; height:90%; ">
				<h4>현재 위치</h4>
				<div id="map" style="width:100%;height:80%;"></div>
			 	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9ab22516ec5317bc7324aed59fb5217f"></script>
			 	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
			 	

					
			</div>	
					
		</div>
	</div>
</div>
</body>
</html>
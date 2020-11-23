<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
* {
   font-family: 'Nanum Gothic', sans-serif;
}
#searchBtn {
				width : 250px;
				height : 35px;
				border : 1px solid  #ab2948;
				background-color :  #ab2948;
				color : #FFFFFF;
				border-radius : 30px;
			}
			
</style>
<meta charset="UTF-8">
<title>솜씽이, 솜솜아 같이 탈래?</title>
</head>
<body>
<body>
<div style="padding:20px 30px 10px 30px">

	<div align="left">
      <a href="<c:url value='/menu' />"><img src="../images/menuicon.png" width="35" height="30" /></a>
   </div>

	<div align="center">
		<h1>솜씽이, 솜솜아 같이 탈래?</h1>
	</div>
	
	<div style=" width:100%; height:80%; border: 1px solid white;">
		<div align="right" style="height:7%; padding:40px 150px 40px 150px;">
		<input type="button" id="searchBtn" value="대여소 검색하기" onclick="location.href='<c:url value='/search/rentalOffice' />'">
		</div>
	</div>
	
	<div style="padding:0px 150px 40px 150px; height:500px;">
		
		<div style="border: 1px solid white;" align="center">
			<div align="center" style="background-color: #f0b3c1; border-radius: 2em; padding:20px 50px 20px 50px;">
				<h4>My Bike</h4><br>
					${user.userName} 님 환영합니다!<br><br>
					사용중인 자전거 : ${rent.bike_id} <br>
					남은 시간 : ${user.remain_time} <br>
			</div>
		</div>
		
		
		<div align="left" style="padding:0px 10px 0px 10px; height:90%; ">
			<h4>현재 위치</h4>
			<div id="map" style="width:100%;height:80%;"></div>
			 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9ab22516ec5317bc7324aed59fb5217f"></script>
			 <script>
			 	if (navigator.geolocation) { // GPS를 지원하면
				    navigator.geolocation.getCurrentPosition(function(position) {
				      var container = document.getElementById('map');
						var options = {
							center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude),
							level: 3
						};
				
						var map = new kakao.maps.Map(container, options);
						
						var markerPosition  = new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude); 

						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
						    position: markerPosition
						});

						// 마커가 지도 위에 표시되도록 설정합니다
						marker.setMap(map);
				    }, function(error) {
				      console.error(error);
				    }, {
				      enableHighAccuracy: false,
				      maximumAge: 0,
				      timeout: Infinity
				    });
				  } else {
				    alert('GPS를 지원하지 않습니다');
				  }
			</script>			
		</div>	
				
	</div>
	
</div>
</body>
</html>
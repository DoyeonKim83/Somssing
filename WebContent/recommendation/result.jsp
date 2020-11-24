<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>검색 결과</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel=stylesheet href="<c:url value='/css/recommendation.css' />" type="text/css">
</head>
<body>
<br><br>
<div data-obj-id="S6vzb" data-obj-type="icon"><svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" viewBox="0 0 48 48" data-svg-content="true" fill="#000000"><path d="M44.34 18.34c0-7.73-6.27-14-14-14s-14 6.27-14 14c0 6.93 5.04 12.67 11.66 13.79V40H12v-6h2v-8c0-1.1-.9-2-2-2H6c-1.1 0-2 .9-2 2v8h2v10h32v-4h-6v-7.76c6.95-.82 12.34-6.73 12.34-13.9zM9 22c1.66 0 3-1.34 3-3s-1.34-3-3-3-3 1.34-3 3 1.34 3 3 3z"></path></svg></div>
<div data-text-content="true" style="font-size:16px; font-weight: bold;">검색 결과</div><br>
         <table>
              <tr height="40">
               <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">산책로 이름</td>
               <td width="250" bgcolor="ffffff" style="padding-left: 10">
                  ${route.route_name}
               </td>
            </tr>
            <tr height="40">
               <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">분위기</td>
               <td width="250" bgcolor="ffffff" style="padding-left: 10">
                  ${route.route_mood}
               </td>
            </tr>
            <tr height="40">
               <td width="150" bgcolor="f0b3c1" align="center" bgcolor="E6ECDE">난이도</td>
               <td width="250" bgcolor="ffffff" style="padding-left: 10">
                  ${route.route_level}
               </td>
            </tr>
         </table><br>
   <div id="map" style="width:100%;height:350px;"></div>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9ab22516ec5317bc7324aed59fb5217f&libraries=services"></script>
   <script>
   // 마커를 담을 배열입니다
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

   // 지도를 생성합니다    
   var map = new kakao.maps.Map(mapContainer, mapOption); 
   
   // 주소-좌표 변환 객체를 생성합니다
   var geocoder = new kakao.maps.services.Geocoder();
   
   // 주소로 좌표를 검색합니다
   geocoder.addressSearch('<c:out value="${route.route_position}" />', function(result, status) {
   
       // 정상적으로 검색이 완료됐으면 
        if (status === kakao.maps.services.Status.OK) {
   
           var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
   
           // 결과값으로 받은 위치를 마커로 표시합니다
           var marker = new kakao.maps.Marker({
               map: map,
               position: coords
           });
   
           // 인포윈도우로 장소에 대한 설명을 표시합니다
           var infowindow = new kakao.maps.InfoWindow({
               content: '<div style="width:150px;text-align:center;padding:6px 0;"><c:out value="${route.route_name}" /></div>'
           });
           infowindow.open(map, marker);
   
           // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
           map.setCenter(coords);
       } 
   });    
   </script>
</body>
</html>
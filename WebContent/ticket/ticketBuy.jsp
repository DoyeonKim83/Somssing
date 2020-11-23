<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>이용권구매</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
 <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

function selectTime(time) {
	if (time.value == "1") var t = 1;
	else if (time.value == "2") var t = 2;
	else if (time.value == "3") var t = 3;
	else if (time.value == "4") var t = 4;
	else if (time.value == "6") var t = 6;
	else if (time.value == "8") var t = 8;
	
	sum = document.form.output_money;
	System.out.print(sum);
	document.getElementById("output_money").value = sum*1000;
	sum.value = parseInt(t) * 1000;
}

function BuyClick() {
	f.submit();
}

function Increment() {
    var count = document.getElementsByName("ps_num")[0];
    var money = document.getElementById("money");
    var cost  = 1000;
    var arg = arguments[0];
    switch(arg){
      case 1:
              ++count.value;
              if (count.value == 10) {
            	  alert("10시간 이상은 선택하실 수 없습니다.");
            	  --count.value;
              }
              break;
      case -1:
              --count.value;
              if (count.value == 0) {
            	  alert("1시간 이상만 가능합니다.");
            	  ++count.value;
              }
              break;
      default:
                break;
    }
    money.innerHTML = (cost * count.value)+"원";
   
  }
 window.onload = function(){
  Increment();
  }
</script>
<style>
	@import url(http://www.openhiun.com/hangul/nanumbarungothic.css);
	#buy_btn {
		width : 280;
		height : 35;
		border : 1px solid #ab2948;
		background-color : #ab2948;
		color : #FFFFFF;
		border-radius : 30px;
	}
	
	#gomainbtn {
		width : 150;
		height : 35;
		border : 1px solid black;
		color : #000000;
		background-color : #FFFFFF;
		border-radius : 30px;
	}
	
	body {
  		font-family: 'Nanum Barun Gothic', sans-serif;
	}
	
	table {
    	border-collapse: collapse;
    }
    
    #ticket_guide {
    	border : 1px solid gray;
    	padding-left: 10; padding-right : 10;
    	padding-top : 10; padding-bottom : 10;
    	font-size:12px;
    	line-height:13px;
    	 
    }
	    
	#td_name {
	    	width : 250;
	    	height : 20;
	    	font-size : 15px;
	    	backround-color : #000000;
	}
	
	#money_box {
		font-size : 20px;
		color : black;
		font-style : bold;
		width : 200;
		height : 30;
		background-color : #ffdbe4;
		border-radius : 4px;
	}

</style>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<div align = "center">
<br>
<!-- write Form  -->
<form name="f" method="GET" action="<c:url value='/ticket/buy'/>">
       
	<h3>이용권 구매 안내</h3> 
	
	<table>	<tr> <td id = "ticket_guide">
	-1회 1매씩 구매가 가능합니다. 	<br>
	-<text style="color:#d1150f;" >시간당 1000원 </text>입니다.	<br>
	-예시)1시간 - 1000원, 5시간 - 5000원 	<br>
	-추가 요금은 5분당 200원 과금됩니다. 	<br>
	<text style="color:#d1150f;" >-예시) 기본 초과 1분 ~ 5분 : 200원, 6분 ~ 10분 : 400원 </text>
	</td> </tr> </table>
	
	<table>
	<tr> <td style="height : 20; "></td> </tr>
	<tr> <td align="center" id="td_name">시간 선택</td> </tr>
	<tr> <td align="center"> <!-- 
		<select id="time" onChange="selectTime(this)">
			<option selected value=1>1시간</option>
			<option value=2 >2시간</option>
			<option value=3 >3시간</option>
			<option value=4 >4시간</option>
			<option value=6 >6시간</option>
			<option value=8 >8시간</option>
		</select> -->
		<input type="button" value="감소" onclick='Increment(-1);'>	
		<input type="text" name="ps_num" value="1" class="text" size="3" maxlength="5"  onkeyup="Increment();">
		<input type="button" value="증가" onclick='Increment(1);'>		
		<tr> <td style="height : 20; "></td> </tr>
		
	<tr> <td align="center" id="td_name">결제 금액</td> </tr>
	<tr> <td align="center" id="money_box"> <span id="money"><?=$show_sale_price?></span></td></tr>		
	<tr> <td style="height : 20; "></td> </tr>
	
	<tr> <td align="center" id="td_name">결제 수단</td> </tr>
	<tr> <td align="center" style="font-size:13px;"> 
		<input type="radio" name="pay_method" value="1" >신용카드  
		<input type="radio" name="pay_method" value="2" >휴대폰결제  
		<input type="radio" name="pay_method" value="3" >네이버페이<br> </td> </tr>
	<tr> <td style="height : 20; "></td> </tr>
	
	<tr> <td align="center"> 
		<input type = "button" value = "결제 하기" id = "buy_btn" onClick='BuyClick()'> </td> </tr>	
	<tr> <td align="center" style="font-size:10px;"> 
		<input type="radio" name="ticket_agree" value="ok"> 
			이용권 구매 약관에 동의하며, 결제를 진행합니다. </td> </tr>	
		
	</table>	    
	</form>
</div>
</body>
</html>
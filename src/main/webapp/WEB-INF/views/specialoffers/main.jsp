<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Showcase</title>
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#btnAdd').click(function(){
            var colorCode = $('#color option:selected').val();
            var colorText = $('#color option:selected').html();
            var quantity = $('#quantity').val();
            
            var orderHtml = '색상: ' + colorText + '<input type="hidden" name="color" value="' + colorCode + '" /> / ';
            orderHtml += '수량: <input name="quantity" value="' + quantity + '" /> - ';
            orderHtml += '<input type="button" class="orderRemoveButton" value="취소" />';
            
            var liEl = $('<li/>').html(orderHtml).appendTo('#orders');

            liEl.find('.orderRemoveButton').click(function(){ liEl.remove(); });
        });
    });
</script>
</head>
<body>
<h3><a href='<c:url value="/" />'>홈</a> / Special Offers</h3>
<hr />
<img src="http://likecool.com/Gear/Office/Swiss%20Pens/Swiss-Pens.jpg" /><br />
제품명: 맥가이버 펜 / 정가: 10,000원 / 할인가: 990원<br />
색상: <select id="color">
    <option value="pink">핑크</option>
    <option value="green">초록</option>
    <option value="yellow">노랑</option>
    <option value="violet">보라</option>
    <option value="black">검정</option>
    <option value="orange">주황</option>
    <option value="red">빨강</option>
    <option value="blue">파랑</option>
</select> 
수량: <input id="quantity" value="1" /> 
<input type="button" id="btnAdd" value="추가" /><br />
<hr />
<h3>주문정보</h3>
<form id='formOrder' action='<c:url value="/specialoffers/orderconfirmation" />' method='post'>
- 주문상품 목록:
<ul id="orders"></ul>
- 배송지 정보<br />
<table>
<tr>
    <td width="100px" align="right">받는 사람:</td>
    <td><input type="text" name="name" value="" /></td>
</tr>
<tr>
    <td width="100px" align="right">연락처:</td>
    <td><input type="text" name="telno" value="" /></td>
</tr>
<tr>
    <td width="100px" align="right">받을 주소:</td>
    <td><input type="text" name="address" value="" size="50" /></td>
</tr>
</table>
<input type="submit" value="주문" style="width:100%;" />
</form>
</body>
</html>
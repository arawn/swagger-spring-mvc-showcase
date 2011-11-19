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
    $.ajaxSetup({"error":function(XMLHttpRequest, textStatus, errorThrown) {   
        try {
            var json = $.parseJSON(XMLHttpRequest.responseText);
            if(json.exception.message)
                alert(json.exception.message);
            else
                throw 'no message!';
        } catch(e) {
            alert('요청 처리 중 오류가 발생했습니다.');
        }     
    }});
    
    $(document).ready(function(){
        if(${hasNextPage}) {
            var btnMore = $('#btnMore');
            
            btnMore.show();
            btnMore.data('condition', {
                'year':'${condition.year}', 
                'month':'${condition.month}',
                'page':'${condition.page+1}',
                'size':'${condition.size}'
            });
        }
        
        $('#btnMore').click(function(){
            var btnMore = $(this);
            if(btnMore.data('condition')) {
                $.getJSON('<c:url value="/showcase/bestseller/book" />', btnMore.data('condition'), function(data){
                    if(data.bestSellers) {
                        $.each(data.bestSellers, function(idx, bestSeller) {
                            var text = bestSeller.rank + '위 - ' + bestSeller.product.title;
                            $('<li/>').html(text).appendTo('#bestSellers');
                        });
                    }
                    if(data.condition) {
                        data.condition.page = data.condition.page + 1; 
                        btnMore.data('condition', data.condition);
                    }
                    if(!data.hasNextPage){
                        btnMore.hide();
                    }
                });
            }
        });
    });
</script>
</head>
<body>
<h3><a href='<c:url value="/" />'>홈</a> / <a href='<c:url value="/showcase/bestseller" />'>베스트셀러</a> / 책 / phone</h3>
<hr/>
<a href='<c:url value="/showcase/bestseller/album" />'>음반</a> | 
<a href='<c:url value="/showcase/bestseller/movie" />'>영화</a>
<hr/>
<ul id="bestSellers">
<c:forEach items="${bestSellers}" var="bestSeller">
<li>${bestSeller.rank}위 - ${bestSeller.product.title}</li>
</c:forEach>
</ul>
<button id="btnMore" style="display: none;">더보기</button>
</body>
</html>
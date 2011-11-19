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
    });
</script>
</head>
<body>
<h3><a href='<c:url value="/" />'>홈</a> / 베스트셀러 / tablet</h3>
<hr />
<a href='<c:url value="/showcase/bestseller/book" />'>책</a> | 
<a href='<c:url value="/showcase/bestseller/album" />'>음반</a> | 
<a href='<c:url value="/showcase/bestseller/movie" />'>영화</a>
<hr />
<h5>책 베스트셀러 TOP 3</h5>
<ul id="bestSellers">
<c:forEach items="${bookBestSellers}" var="bestSeller">
<li>${bestSeller.rank}위 - ${bestSeller.product.title}</li>
</c:forEach>
</ul>
<h5>음반 베스트셀러 TOP 3</h5>
<ul id="bestSellers">
<c:forEach items="${albumBestSellers}" var="bestSeller">
<li>${bestSeller.rank}위 - ${bestSeller.product.title}</li>
</c:forEach>
</ul>
<h5>영화 베스트셀러 TOP 3</h5>
<ul id="bestSellers">
<c:forEach items="${movieBestSellers}" var="bestSeller">
<li>${bestSeller.rank}위 - ${bestSeller.product.title}</li>
</c:forEach>
</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰 상세</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<h1>운동 영상 리뷰</h1>
	<hr>
	
	<div id="button">
	<!-- 목록보기, 수정, 삭제 버튼이 들어갈 위치 -->
		<a href="main?act=list&videoId=${review.videoId }"><button type="button">목록으로</button></a>
		<a href="main?act=modifyform&reviewId=${review.id }"><button type="button">수정</button></a>
		<form method="POST" action="main">
			<Input type="hidden" name="act" value="remove">
			<Input type="hidden" name="reviewId" value="${review.id }">
			<Input type="hidden" name="videoId" value="${review.videoId }">
			<Input type="submit" value="삭제">
		</form>
	</div>
	<hr>
	<div id="box">
		<div id="review_title">
			<h3>제목: ${review.title }</h3>
		</div>
		<div id="review_content">
			${review.content }
		</div>
		<div id="reivew_information">
			작성자 : ${review.writer }
			작성일 : ${review.regDate }
		</div>
	</div>
</body>
</html>
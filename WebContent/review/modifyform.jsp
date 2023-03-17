<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	
	<h1>리뷰 수정</h1>
	<hr>
	
	<!-- 수정할 리뷰의 제목, 작성자  -->
	<form action="main" method="POST">
		<input type="hidden" name="act" value="modify">
		제목 : <input type="text" name="title" value=${review.title }><br>
		쓰니 : <input type="text" name="writer" disabled value=${review.writer }><br>
		내용 : <textarea rows="10" cols="10" name="content">${review.content }</textarea><br> 
		<input type="submit" value="수정">
	</form>
	
</body>
</html>
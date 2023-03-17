<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	
	<h1>리뷰 등록</h1>
	<hr>
	
	<form action="main" method="POST">
		<input type="hidden" name="act" value="write">
		제목 : <input type="text" name="title" ><br>
		쓰니 : <input type="text" name="writer" ><br>
		내용 : <textarea rows="10" cols="10" name="content"></textarea><br><br>
		<input type="submit" value="수정">
	</form>
	
</body>
</html>
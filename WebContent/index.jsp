<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFIT</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	
	<h1>SSAFIT</h1>
	<hr>
	
	<div>
		<h2>가장 많이 본 영상</h2>
		<hr>
		<c:if test="${ list != null }" >
		<table>
			<tr>
				<th>영상</th>
				<th>제목</th>
				<th>채널이름</th>
				<th>조회수</th>
				<th>카테고리</th>
			</tr>
			<c:forEach items="${ list}" var="video">
			<tr>
				<th><a href="main?act=list&videoId=1">
				<img width="360" src="https://i.ytimg.com/vi/${video.img }">
				</a></th>
				<th>${video.title }</th>
				<th>${video.channelName }</th>
				<th>${video.viewCnt }</th>
				<th>${video.fitPartName }</th>
			</tr>
			</c:forEach>
		</table>
		</c:if>
		
		<!--  
		<form action="main">
        <input type="hidden" name="act" value="mainList">
        <input id="getListInfo" type="submit" value="제출"></input>
    	</form>
    	-->
		
		<div>
			<a href="main?act=list&videoId=1"><img width="360" src="https://i.ytimg.com/vi/myNjmnvI6x0/hq720.jpg"></a>
		</div>
		<div>
			<a href="main?act=list&videoId=2"><img width="360" src="https://i.ytimg.com/vi/gMaB-fG4u4g/hq720.jpg"></a>
		</div>
		<div>
			<a href="main?act=list&videoId=3"><img width="360" src="https://i.ytimg.com/vi/5MACh6ylf8g/hq720.jpg"></a>
		</div>
		
	</div>
	
</body>
<script>
/*    document.querySelector("#getListInfo").click(); */
</script>
</html>
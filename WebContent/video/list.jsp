<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비디오 상세 화면</title>
</head>
<body>
	<h1>비디오 상세 화면</h1>
	<hr>
	<div>
		<div>영상번호 : ${video.id }</div>
		<div>제목 : ${video.title }</div>
		<div>부위 : ${video.fitPartName }</div>
		<div>채널명 : ${video.channelName }</div>
		<div>조회수 : ${video.viewCnt }</div>
		<iframe width="560" height="315" src="https://www.youtube.com/embed/${video.youtubeId }" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
		</iframe>
	</div>
	<hr>
	<a href="main?act=writeform&videoId=${video.id }"> <button type="button">리뷰 등록</button> </a>	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${requestScope.reviewList }" var="review">
			<tr>
				<td>${review.id }</td>
				<td>
					<a href="main?act=detail&id=${review.id }">
						${review.title }
					</a>
				</td>
				<td>${review.writer }</td>
				<td>${review.regDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
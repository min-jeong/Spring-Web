<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #f8f8f8;">
<div style="text-align: center; position:relative; top: 100px;">
<h1> ARTICLE LIST </h1>
<table border="1" width="1000px" align="center">
	<tr>
		<th>ARTICLE ID</th>
		<th>ARTICLE NUMBER</th>
		<th>SUBJECT</th>
		<th>WRITER</th>
		<th>CREATED DATE</th>
		<th>MODIFIED DATE</th>
	</tr>
	<c:forEach items="${articleListVO.articleList}" var="article">
	<tr>
		<td>${ article.articleId }</td>
		<td>${ article.articleNumber }</td>
		<td>
		<a href="/board/detail/${ article.articleId }">${ article.subject }</a>
		</td>
		<td>${ article.writer }</td>
		<td>${ article.createdDate }</td>
		<td>${ article.modifiedDate }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" align="center">
		<a href="/board/write"><input type="button" value="글쓰기" /></a>
		</td>
	</tr>
	<tr>
		<td colspan="6" align="center">
			<form id="pagingForm">
				${ articleListVO.paging.getPagingList("pageNo" , "[@]", "이전", "다음", "pagingForm") }
			</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>
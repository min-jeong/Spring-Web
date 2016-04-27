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
<h1> DETAIL ARTICLE </h1>
<table border="1" width="1000px" align="center">
	<tr>
		<th>ARTICLE ID</th>
		<th>ARTICLE NUMBER</th>
		<th>SUBJECT</th>
		<th>WRITER</th>
		<th>DESCRIPTION</th>
		<th>CREATED DATE</th>
		<th>MODIFIED DATE</th>
	</tr>
	<tr>
		<td>${ article.articleId }</td>
		<td>${ article.articleNumber }</td>
		<td>${ article.subject }</td>
		<td>${ article.writer }</td>
		<td>${ article.description }</td>
		<td>${ article.createdDate }</td>
		<td>${ article.modifiedDate }</td>
	</tr>
	<tr>
		<td colspan="7">
		<a href="/board/list"><input type="button" value="목록"/></a>
		<a href="/board/delete/${ article.articleId }"><input type="button" value="삭제"/></a>
		<a href="/board/modify/${ article.articleId }"><input type="button" value="수정"/></a>
		</td>
</table>
</div>
</body>
</html>
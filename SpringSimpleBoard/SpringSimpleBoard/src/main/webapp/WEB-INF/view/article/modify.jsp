<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: #f8f8f8;">
<div style="text-align: center; position:relative; top: 100px;">
<h1>WRITE ARTICLE</h1>
<form:form commandName="articleVO" method="post" action="/board/doModifyAction">
	<input type="hidden" id="articleId" name="articleId" value="${ articleVO.articleId }" />
	<input type="text" id="subject" name="subject" placeholder="제목을 입력하세요." value="${ articleVO.subject }"
				style="width : 400px;  line-height: 1.5; border-radius: 0; "/><br/>
	<form:errors path="subject" /><br/>

	<input type="text" id="writer" name="writer" placeholder = "글쓴이를 입력하세요." value="${ articleVO.writer }"
				style="width : 400px; line-height: 1.5; border-radius: 0;"/><br/>
	<form:errors path="writer" /><br/>

	<textarea id="description" name="description" placeholder="내용을 입력하세요." cols="55" rows="5" >${ articleVO.description }</textarea><br/>
	
	<input type="submit" value="수정" />
</form:form>
</div>
</body>
</html>
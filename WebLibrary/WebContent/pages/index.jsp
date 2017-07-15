<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../elements/el_localization.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Library</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>


<body>
	<h1>${library}</h1>
	<br>
	
	<c:if test="${not empty requestScope.status}">
		<h3>${requestScope.status}</h3>
	</c:if>
	<br>		
	
	<%@include file="../elements/el_content_localization.jspf"%>
	<%@include file="../elements/el_content_sign_up.jspf"%>		

	<c:if test="${not empty sessionScope.logged}">
		<label style="color: blue">${helloUser}</label>
		<form action="Controller">
			<input type="hidden" name="command" value="out">
			<button type="submit">${out}</button>
		</form>
	
		<%@include file="../elements/el_content_add_new_book.jspf"%>
		<%@include file="../elements/el_content_add_edit_book.jspf"%>
	</c:if>

	<c:if test="${empty sessionScope.logged}">
		<%@include file="../elements/el_content_sign_in.jspf"%>	
	</c:if>
	<br>
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="get_booklist">
		<button type="submit">${getBooklist}</button>
	</form>
</body>
</html>
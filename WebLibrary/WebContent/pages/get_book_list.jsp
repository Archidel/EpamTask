<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../../elements/el_localization.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>${library}</h1>
	<table border="1">
		<caption>${booklist}</caption>
		<thead>
	    	<tr>
	    		<th>${idBook}</th>
	       		<th>${title}</th>
	       		<th>${author}</th>
	       		<th>${genre}</th>
	       		<th>${year}</th>	
	       		<th>${quantity}</th>	
	     	</tr>
	    </thead> 
	    	
	    <c:forEach items="${requestScope.list}" var = "list">
			<tbody>
		   		<tr>
		   			<th>${list.id}</th>
					<td>${list.title}</td>
				    <td>${list.author}</td>
				    <td>${list.genre}</td>
				    <td>${list.year}</td>
				    <td>${list.quantity}</td>
		 		</tr>	
			</tbody>			
		</c:forEach> 
	</table>
	
	<a href="index">${backToMainPage}</a>

</body>
</html>
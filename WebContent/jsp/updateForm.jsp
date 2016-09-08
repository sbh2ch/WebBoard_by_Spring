<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/attach/top.jsp" %>
		</div>
		
		<div class="content">
			<h1>modify</h1>
			<form action="/Test04/board/update.do" accept-charset="utf-8" enctype="multipart/form-data" method="post">
				<input type="hidden" name="no" value="${b.no}">
				<table width="60%" border="1">
					<tr>
						<th>title</th>					
						<td><input type="text" name="title" required value="${b.title}"></td>					
					</tr>
					<tr>
						<th>content</th>					
						<td><textarea rows="20" cols="40" name="content" required>${b.content}</textarea></td>					
					</tr>
					<tr>
						<th>attach file</th>					
						<td><input type="file" name="attachFile"></td>					
					</tr>
				</table>
				<input type="submit" value="modify">
			</form>
		</div>
		
		<div class="footer">
			<%@ include file="/attach/bottom.jsp" %>
		</div>
	</div>
</body>
</html>
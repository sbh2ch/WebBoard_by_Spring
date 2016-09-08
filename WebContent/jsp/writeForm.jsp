<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/attach/top.jsp"%>
		</div>

		<div class="content">
			<h1>write</h1>
			<form action="/Test04/board/write.do" accept-charset="utf-8" method="post" enctype="multipart/form-data">
				<table width="60%" border="1">
					<tr>
						<th>title</th>
						<td><input type="text" name="title" required></td>
					</tr>
					<tr>
						<th>content</th>
						<td><textarea name="content" cols="40" rows="20" required></textarea></td>
					</tr>
					<tr>
						<th>attach</th>
						<td><input type="file" name="attachFile"></td>
					</tr>
				</table>
				<input type="submit" value="write">
			</form>
		</div>

		<div class="footer">
			<%@ include file="/attach/bottom.jsp"%>
		</div>
	</div>
</body>
</html>
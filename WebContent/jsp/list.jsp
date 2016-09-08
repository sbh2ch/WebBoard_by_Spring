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
			<h1>Board</h1>
			<table width="60%" border="1">
				<thead>
					<tr>
						<th>no</th>
						<th>title</th>
						<th>writer</th>
						<th>reg_date</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty bList}">
							<tr>
								<th colspan="4">empty board</th>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="b" items="${bList}">
								<fmt:formatDate value="${b.regDate}" pattern="yyyy.MM.dd" var="regDate"/>
								<tr>
									<th>${b.no}</th>
									<th><a href="/Test04/board/detail.do?no=${b.no}">${b.title}</a></th>
									<th>${b.writer}</th>
									<th>${regDate}</th>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<a href="/Test04/board/writeForm.do">write</a>
		</div>
		
		<div class="footer">
			<%@ include file="/attach/bottom.jsp" %>
		</div>
	</div>
</body>
</html>
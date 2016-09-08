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
			<h1>detail</h1>
			<table width="60%" border="1">
				<tr>
					<th>title</th>
					<td>${b.title}</td>
				</tr>
				<tr>
					<th>writer</th>
					<td>${b.writer}</td>
				</tr>
				<tr>
					<th>content</th>
					<td><textarea readonly cols="40" rows="20">${b.content}</textarea> </td>
				</tr>
				<c:if test="${not empty f}">
					<tr>
						<th>attach</th>
						<td>
							<a href="/Test04/down?path=${f.filePath}&oriName=${f.oriName}&realName=${f.realName}">download</a><br>
							<img alt="" src="/Test04/down?path=${f.filePath}&realName=${f.realName}&draw=Y">
						</td>
					</tr>
				</c:if>
			</table>
			<c:if test="${b.owner == user.email}">
				<a href="/Test04/board/updateForm?no=${b.no}">modify</a>&nbsp;<a href="/Test04/board/delete?no=${b.no}">delete</a>
			</c:if>
			<a href="/Test04/board/list.do">back</a>
			<h3>reply</h3>
				<form action="/Test04/reply/update" method="post" accept-charset="utf-8">
					<table width="60%" border="1">
						<thead>
							<tr>
								<th>id</th>
								<th>comment</th>
								<th colspan="2">reg_date</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty rList}">
									<tr>
										<th colspan="4">no reply</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="r" items="${rList}">
										<fmt:formatDate value="${r.regDate}" pattern="yyyy.MM.dd HH:mm:ss" var="regDate"/>
										<tr>
											<th>${r.name}</th>
											<td>${r.content}</td>
											<th>${regDate}</th>
											<c:if test="${r.owner == user.email}">
												<th><input type="hidden" name="replyNo" value="${r.replyNo}"><input type="hidden" name="no" value="${b.no}"><input type="text" name="content"><input type="submit" value="mod" ><a href="/Test04/reply/delete?replyNo=${r.replyNo}&no=${b.no}">del</a></th>
											</c:if>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</form>
			<form action="/Test04/reply/write" method="post" accept-charset="utf-8">
				<input type="hidden" name="no" value="${b.no}">
				<input type="text" name="content" required> <input type="submit" value="comment">
			</form>
		</div>
		
		<div class="footer">
			<%@ include file="/attach/bottom.jsp" %>
		</div>
	</div>
</body>
</html>
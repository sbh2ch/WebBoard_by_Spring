<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
	<c:when test="${empty user}">
		<form action="/Test04/login/login.do" accept-charset="utf-8" method="post">
			<input type="email" name="email" placeholder="E-Mail" required>
			<input type="password" name="pw" placeholder="Password" required> 
			<input type="submit" value="Log in"> <a href="#">Sign in</a>
		</form>
	</c:when>
	<c:otherwise>
			Welcome ${user.name}!&nbsp;<a href="/Test04/login/logout.do">Log out</a>
	</c:otherwise>
</c:choose>
<a href="/Test04/board/list.do">Go to Board</a>
<hr>

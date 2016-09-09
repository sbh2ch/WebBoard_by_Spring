<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
#commentList {
	width: 80%;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<%@ include file="/attach/top.jsp"%>
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
					<td><textarea readonly cols="40" rows="20">${b.content}</textarea></td>
				</tr>
				<c:if test="${not empty f}">
					<tr>
						<th>attach</th>
						<td><a href="/Test04/down?path=${f.filePath}&oriName=${f.oriName}&realName=${f.realName}">download</a><br> <img alt="" src="/Test04/down?path=${f.filePath}&realName=${f.realName}&draw=Y"></td>
					</tr>
				</c:if>
			</table>
			<c:if test="${b.owner == user.email}">
				<a href="/Test04/board/updateForm.do?no=${b.no}">modify</a>&nbsp;<a href="/Test04/board/delete.do?no=${b.no}">delete</a>
			</c:if>
			<a href="/Test04/board/list.do">back</a>
			<h3>reply</h3>
			<div id="commentList"></div>

			<form id="crForm" accept-charset="utf-8">
				<input type="text" name="content" required> <input type="submit" value="comment">
			</form>
		</div>
		<div class="footer">
			<%@ include file="/attach/bottom.jsp"%>
		</div>
	</div>
	<script>
		function commentList() {
			$.ajax({
				url : "/Test04/board/commentList.do",
				data : {
					no : "${b.no}"
				}, // .java로 바뀔 때 해석이 된다.
				dataType : "json"
			}).done(makeCommentList);
		}

		function makeCommentList(result) {
			var html = "";
			if (result.length == 0) {
				html += "<div>댓글이 없음</div>";
			} else {

				for (var i = 0; i < result.length; i++) {
					html += "<div id='comment"+result[i].replyNo+"'>";
					html += "<span> " + result[i].name + " </span>";
					html += "<span> " + result[i].content + " </span>";
					var date = new Date(result[i].regDate);
					var time = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
					html += "<span> " + time + " </span>";
					html += "<span>";
					html += "수정 <a href='#1' onclick='commentDelete(" + result[i].replyNo + ");'>삭제</a>";
					html += "</span>";
					html += "</div>";
				}
			}
			$("#commentList").html(html);
		};

		commentList(); // 상세 페이지 로딩시 댓글 목록 조회, ajax 호출

		//댓글 등록
		$("#crForm").submit(function() {
			var f = document.querySelector("#crForm");
			$.ajax({
				type : "post",
				url : "/Test04/reply/write.do",
				data : {
					no : "${b.no}",
					content : f.content.value
				},
				dataType : "json"
			}).done(function(result) {
				makeCommentList(result);
				f.content.value = "";
			});

			return false;
		});

		function commentDelete(commentNo) {
			var f = document.querySelector("#crForm");
			$.ajax({
				type : "post",
				url : "/Test04/reply/delete.do",
				data : {
					no : "${b.no}",
					replyNo : commentNo
				},
				dataType : "json"
			}).done(makeCommentList);

			return false;
		}
	</script>
</body>
</html>
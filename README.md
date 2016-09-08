# Spring 기반 게시판

본 프로젝트는 Servlet & Jsp기반의 게시판을 직접 Spring framework를 구현해 게시판을 만드는 과정을 단계별로 구현한 프로젝트다.
기존의 Servlet & Jsp기반의 게시판은 다음과 같다

<h3>board Step 1</h3>

<ul>
  <li>resources : MyBatis3, Oracle 설정</li>
  <li>MyAppSqlConfig : Oracle 설정</li>
  <li>sqlmap.oracle : reply, board, member, file xml을 나눠 사용함</li>
</ul>
<br>
<br>
<br>
<h3>board Step 2 (list, Login)</h3>
<ul>
  <li>ListController : 리스트 서블릿</li>
  <li>board : 게시판 VO, DAO</li>
  <li>selectAll : 모든 게시물 출력</li>
  <li>selectOne : 한 게시물 출력</li>
  <li>update : 게시물 수정</li>
  <li>delete : 게시물 삭제</li>
  <li>insert : 게시물 등록</li>
  <li>login : 로그인</li>
  <li>logout : 로그아웃</li>
</ul>
<br>
<h5>URL: http://localhost:8000/board/list</h5>
<br>
<br>
<br>
<h3>board Step 3 (detail, file)</h3>
<ul>
  <li>DetailController : 상세보기 서블릿</li>
  <li>detail.jsp : 상세보기 form</li>
  <li>file : 파일 VO, DAO</li>
</ul>
<br>
<h5>URL: http://localhost:8000/board/detail</h5>
<br>
<br>
<br>
<h3>board Step 4 (delete, update)</h3>
<ul>
  <li>DeleteController : 삭제 서블릿</li>
  <li>UpdateController : 수정 서블릿</li>
</ul>
<br>
<h5>URL: http://localhost:8000/board/update?no=</h5>
<br>
<br>
<br>
<h3>board Step 5 (reply)</h3>
<ul>
  <li>reply : replyDAO, replyVO</li>
  <li>DAO는 board와 동일</li>
</ul>
<br>
<br>
<br>
<h3>board Step 6 (paging)</h3>
<ul>
  <li>페이징</li>
</ul>
<br>
<br>
<br>
<br>
<br>
<br>

<h3>개발 환경 ###</h3>

Programming Language - Java 1.8_101<br>
IDE - Eclipse<br>
DB - Oracle10XE <br>
ELSE - MyBatis, JSP, Servlet, JSTL, Spring framework<br>
<br>
<br>
<br>
<br>
<br>
<br>

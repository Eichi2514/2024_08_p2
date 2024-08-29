<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="메인"></c:set>
<%@ include file="../common/head.jspf"%>

<div class="bg relative">
    <!-- p1 홈페이지 배경 -->
	<img src="https://github.com/user-attachments/assets/007e8af7-3561-4c0d-8585-6c941cbde9ad" alt="" />
	<form method="POST" action="../member/doLogin">
		<c:if test="${!rq.isLogined() }">

			<div class="id absolute text_color">
				I D : <input class="csp" type="text" placeholder="아이디 입력" name="loginId" />
			</div>

			<div class="pw absolute text_color">
				PW : <input class="csp" type="password" placeholder="비밀번호 입력" name="loginPw"></input>
			</div>


			<a class="join_bt absolute text_color" href="../member/join">회 원 가 입</a>


			<button class="login_out_bt absolute text_color" type="submit">로 그 인</button>
		</c:if>
		<c:if test="${rq.isLogined() }">

			<div class="member_name absolute text_color">
				${loginedMemberNickname }님 <br /> 환영합니다
			</div>
			<div class="start absolute cursor-pointer">
				<a class="start-text absolute" href="../charac/choice">게임시작</a> 
				<!-- p1 게임시작 호버 전 -->
				<img class="start-1" src="https://github.com/user-attachments/assets/f3f4bbe0-bdb9-4960-b9cd-968471a760fb" alt="" />
				<!-- p1 게임시작 호버 후 -->
				<img class="start-2" src="https://github.com/user-attachments/assets/7f9beadb-1431-4f67-b06e-0f95ad29d4fc" alt="" />
			</div>
			<div class="login_out_bt absolute text_color">
				<a href="../member/doLogout">로그아웃</a>
			</div>
		</c:if>
	</form>


</div>

<%@ include file="../common/foot.jspf"%>
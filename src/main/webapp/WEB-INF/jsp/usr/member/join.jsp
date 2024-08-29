<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입"></c:set>
<%@ include file="../common/head.jspf"%>

<div class="bg relative">
	<img src="https://github.com/user-attachments/assets/b5f5d356-760d-44f0-be02-bb57a6277329" alt="" />

	<div class="doJoin_bg text_color absolute">
		<div class="doJoin_title absolute">회 원 가 입</div>

		<form method="POST" action="doJoin">

			<div class="text_color doJoin_id absolute doJoin_ph">
				<div class="label">아 이 디</div>
				<input type="text" placeholder="아이디 입력" name="loginId" />
			</div>
			<div class="text_color doJoin_pw absolute doJoin_ph">
				<div class="label">비밀번호</div>
				<input type="password" placeholder="비밀번호 입력" name="loginPw" />
			</div>

			<div class="text_color doJoin_pw2 absolute doJoin_ph">
				<div class="label">
					재확인 <br /> 비밀번호 
				</div>
				<input type="password" placeholder="비밀번호 입력" name="loginPw2" />
			</div>

			<div class="text_color doJoin_name absolute doJoin_ph">
				<div class="label">이 름</div>
				<input type="text" placeholder="이름 입력" name="name" />
			</div>
			<div class="text_color doJoin_nickname absolute doJoin_ph">
				<div class="label">닉 네 임</div>
				<input type="text" placeholder="닉네임 입력" name="nickname" />
			</div>
			<div class="text_color doJoin_cellphoneNum absolute doJoin_ph">
				<div class="label">전화번호</div>
				<input type="text" placeholder="전화번호 입력" name="cellphoneNum" />
			</div>
			<div class="text_color doJoin_email absolute doJoin_ph">
				<div class="label">이 메 일</div>
				<input type="email" placeholder="이메일 입력" name="email" />
			</div>

			<button class="text_color doJoin_bt absolute" type="submit">회원가입</button>
			<a class="text_color doJoin_exit absolute" href="/">취소</a>
		</form>
	</div>


</div>

<%@ include file="../common/foot.jspf"%>
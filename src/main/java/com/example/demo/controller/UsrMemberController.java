package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.util.Ut;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsrMemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpServletRequest req) {

		Rq rq = (Rq) req.getAttribute("rq");

		rq.logout();

		return Ut.jsReplace("S-1", Ut.f("로그아웃 되었습니다"), "/");
	}

	@RequestMapping("/usr/member/login")
	public String showLogin() {
		return "/usr/member/login";
	}

	@RequestMapping("/usr/member/join")
	public String showJoin() {
		return "/usr/member/join";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest req, String loginId, String loginPw) {

		Rq rq = (Rq) req.getAttribute("rq");

		if (Ut.isEmptyOrNull(loginId)) {
			return Ut.jsHistoryBack("F-1", "ID를 입력해주세요");
		}
		if (Ut.isEmptyOrNull(loginPw)) {
			return Ut.jsHistoryBack("F-2", "PW를 입력해주세요");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return Ut.jsHistoryBack("F-3", Ut.f("%s는(은) 존재하지 않습니다", loginId));
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return Ut.jsHistoryBack("F-4", Ut.f("비밀번호가 틀렸습니다"));
		}

		rq.login(member);

		return Ut.jsReplace("S-1", Ut.f("%s님 환영합니다", member.getNickname()), "/");
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(HttpSession httpSession, String loginId, String loginPw, String loginPw2, String name,
			String nickname, String cellphoneNum, String email) {

		if (Ut.isEmptyOrNull(loginId)) {
			return Ut.jsReplace("F-1", "아이디를 입력해주세요", "join");
		}
		if (Ut.isEmptyOrNull(loginPw)) {
			return Ut.jsReplace("F-2", "비밀번호를 입력해주세요", "join");
		}
		if (Ut.isEmptyOrNull(loginPw2)) {
			return Ut.jsReplace("F-2", "재확인 비밀번호를 입력해주세요", "join");
		}
		if (!loginPw.contains(loginPw2)) {
			return Ut.jsReplace("F-2", "비밀번호가 일치하지 않습니다", "join");
		}
		if (Ut.isEmptyOrNull(name)) {
			return Ut.jsReplace("F-3", "이름을 입력해주세요", "join");
		}
		if (Ut.isEmptyOrNull(nickname)) {
			return Ut.jsReplace("F-4", "닉네임을 입력해주세요", "join");
		}
		if (Ut.isEmptyOrNull(cellphoneNum)) {
			return Ut.jsReplace("F-5", "전화번호를 입력해주세요", "join");
		}
		if (cellphoneNum.length() != 11 || !cellphoneNum.startsWith("010")) {
			return Ut.jsReplace("F-5", "잘못된 전화번호입니다", "join");
		}
		if (Ut.isEmptyOrNull(email)) {
			return Ut.jsReplace("F-6", "이메일을 입력해주세요", "join");
		}
		if (!email.contains(".")) {
			return Ut.jsReplace("F-6", "잘못된 이메일입니다", "join");
		}

		ResultData doJoinRd = memberService.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);

		if (doJoinRd.isFail()) {
			return Ut.jsReplace(doJoinRd.getResultCode(), doJoinRd.getMsg(), "join");
		}
		
		return Ut.jsReplace("S-1", Ut.f("%s님 환영합니다", nickname), "/");
	}

}
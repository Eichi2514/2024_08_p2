package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CharacService;
import com.example.demo.service.MapService;
import com.example.demo.vo.Charac;
import com.example.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrMapController {

	@Autowired
	private CharacService characService;
	
	@Autowired
	private MapService mapService;

	@RequestMapping("/usr/map/front")
	public String showFront(HttpServletRequest req, Model model) {
		
		// 높이와 넓이를 전달해서 맵 생성
		int[][] map = mapService.mapCreation(52,52,46,22);
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		// 캐릭터가 존재하는지 확인
		Charac charac = characService.characChack(rq.getLoginedMemberId());
		
		// 캐릭터가 없다면 생성 후 모델로 보내주고 있다면 바로 보내주기
		if (charac == null) {
			charac = characService.characCreation(rq.getLoginedMemberId());
			model.addAttribute("charac", charac);
		} else {
			model.addAttribute("charac", charac);			
		}
	
		return "/usr/map/front";
	}
}
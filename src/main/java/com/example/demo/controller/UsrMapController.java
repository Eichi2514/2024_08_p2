package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.example.demo.service.CharacService;
import com.example.demo.vo.Charac;
import com.example.demo.vo.ResultData;
import com.example.demo.vo.Rq;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UsrMapController {
	
	@Autowired
	private CharacService characService;

	@RequestMapping("/usr/map/front")
	public String showFront(HttpServletRequest req, Model model) {
		
		Rq rq = (Rq) req.getAttribute("rq");

		Charac charac = characService.characChack(rq.getLoginedMemberId());
		
		if (charac == null) {
			charac = characService.characCreation(rq.getLoginedMemberId());
			model.addAttribute("charac", charac);
		} else {
			model.addAttribute("charac", charac);			
		}
	
		return "/usr/map/front";
	}
}
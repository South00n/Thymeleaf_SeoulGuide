package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.dao.SeoulLocationDAO;
import com.sist.web.dao.SeoulNatureDAO;
import com.sist.web.dao.SeoulShopDAO;
import com.sist.web.entity.SeoulLocationEntity;
import com.sist.web.entity.SeoulNatureEntity;
import com.sist.web.entity.SeoulShopEntity;

import java.util.*;

@Controller
public class MainController {
	@Autowired
	private SeoulLocationDAO ldao;
	@Autowired
	private SeoulNatureDAO ndao;
	@Autowired
	private SeoulShopDAO sdao;
	
	@GetMapping("/")
	public String main_page(Model model) {
		List<SeoulLocationEntity> list = ldao.seoulLocationData();
		List<SeoulNatureEntity> list2 = ndao.seoulNatureData();
		List<SeoulShopEntity> list3 = sdao.seoulShopData();
		
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("main_html", "main/home");
		return "main";
	}
}

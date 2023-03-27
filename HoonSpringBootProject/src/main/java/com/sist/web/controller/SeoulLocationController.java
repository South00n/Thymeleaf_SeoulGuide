package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.SeoulLocationDAO;
import com.sist.web.entity.SeoulLocationEntity;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@RequestMapping("seoul/")
public class SeoulLocationController {
	@Autowired
	private SeoulLocationDAO dao;
	
	@GetMapping("seoul_location")
	public String food_list(String page,Model model) {
	
		if(page==null) {
			page="1";
		}
		
		int curpage = Integer.parseInt(page);
		int rowSize = 20;
		int start = (curpage * rowSize) - rowSize;
	 	List<SeoulLocationEntity> list = dao.seoulLocationListData(start);
	 	
	 	int totalpage = dao.seoulLocationListTotalPage();
	 	final int BLOCK = 5;
	 	
	 	int startPage = ((curpage-1) / BLOCK*BLOCK) + 1;
	 	int endPage = ((curpage-1) / BLOCK*BLOCK) + BLOCK;
	 	if(endPage > totalpage) {
	 		endPage = totalpage;
	 	}
	 	System.out.println(curpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	 	model.addAttribute("list", list);
		model.addAttribute("main_html", "seoul/seoul_location");
		return "main";
	}
	
	@GetMapping("seoul_location_detail")
	public String food_detail(int no,Model model) {
		
		SeoulLocationEntity vo = dao.findByno(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "seoul/seoul_location_detail");
		return "main";
	}
}

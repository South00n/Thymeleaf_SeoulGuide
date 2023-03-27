package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller
@RequestMapping("food/")
public class FoodController {
   @Autowired
   private FoodLocationDAO fDao;
   
   @RequestMapping("food_find")
   public String food_find(String address,String page,Model model)
   {
	   if(address==null)
		   address="역삼";
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=20;
	   int start=(curpage*rowSize)-rowSize;
	   List<FoodLocationEntity> list=fDao.foodFindData(address, start);
	   for(FoodLocationEntity vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   poster=poster.replace("#", "&");
		   vo.setPoster(poster);
	   }
	   int totalpage=fDao.foodFindTotalPage(address);
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
	   model.addAttribute("address", address);
	   model.addAttribute("main_html", "food/food_find");
	   return "main";
   }
   @GetMapping("find_detail")
   public String find_detail(int fno,Model model)
   {
	   FoodLocationEntity vo=fDao.findByFno(fno);
	   String poster=vo.getPoster();
	   List<String> pList=new ArrayList<String>();
	   StringTokenizer st=new StringTokenizer(poster,"^");
	   while(st.hasMoreTokens())
	   {
		   pList.add(st.nextToken());
	   }
	   model.addAttribute("pList", pList);
	   String addr1=vo.getAddress();
	   addr1=addr1.substring(0,addr1.lastIndexOf("지"));
	   model.addAttribute("addr1", addr1.trim());
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_html", "food/find_detail");
	   return "main";
   }
}








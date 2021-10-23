package com.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	 @Inject
	 private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) throws Exception {
		  List list = service.list();
		  model.addAttribute("list", list);
		  
		  return "/board/list";
	}
	
	@RequestMapping(value = "/regiView", method = RequestMethod.GET)
	public String regiView(Locale locale, Model model) throws Exception {
		return "/board/regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public  String regi(Locale locale, Model model, BoardDTO dto) throws Exception {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		
		dto.setReg_date(format.format(date));
		
		if(service.regi(dto) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String view(Locale locale, Model model, HttpServletRequest request) throws Exception {
		BoardDTO dto = service.view(Integer.parseInt((String)request.getParameter("seq")));
		model.addAttribute("view", dto);
		return "/board/view";
	}
	
	@RequestMapping(value = "/goUpdateView", method = RequestMethod.POST)
	public String updateView(Locale locale, Model model, HttpServletRequest request) throws Exception {
		BoardDTO dto = service.view(Integer.parseInt((String)request.getParameter("seq")));
		model.addAttribute("view", dto);
		return "/board/update";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Locale locale, Model model, BoardDTO dto) throws Exception {
		if(service.update(dto) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Locale locale, Model model, HttpServletRequest request) throws Exception {
		if(service.delete(Integer.parseInt((String)request.getParameter("seq"))) == 1) {
			return "Y";
		}else {
			return "N";
		}
	}
}
package org.joonzis.controller;

import org.joonzis.domain.BoardVO;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	// 서비스 객체 받아와야 됨
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list...");
		//1. 서비스에서 getList() 호출
		//2. 받아 온 list 데이터를 화면에 전달
		model.addAttribute("list", service.getList());
		
		return "board/list";
	}
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register....." + vo);
		
		service.register(vo);
		
		rttr.addFlashAttribute("result", "ok");
		
		return "redirect:/board/list"; // redirect로 list이동
	}
	@GetMapping("/register")
	public String register() {
		return "board/register";
	}
	@GetMapping("/get")
	public String get(@RequestParam("bno")long bno, Model model) {
			log.info("/get..." + bno);
			model.addAttribute("vo", service.get(bno));
		return "board/get";
	}
	@GetMapping
	public String modify(@RequestParam("bno") long bno, Model model) {
		log.info("modify");
		model.addAttribute("vo", service.get(bno));
		
		return "board/modify";
	}
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("modify...." + vo);
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");	
		}
		return "redirect:/board/list";	
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") long bno, RedirectAttributes rttr) {
		
		log.info("remove...." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
